package com.example.capstone3.Service;

import com.example.capstone3.API.APIException;
import com.example.capstone3.Model.Appeal;
import com.example.capstone3.Model.Case;
import com.example.capstone3.Repositry.AppealRepository;
import com.example.capstone3.Repositry.CaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Service
public class AppealService {

    private  final AppealRepository appealRepository;
    private final CaseRepository caseRepository;

    public List<Appeal> getall(){
        if (appealRepository.findAll().isEmpty())
        {  throw new APIException("Empty Appeal");}
        else{

            return appealRepository.findAll();

        }
    }
    //---------------------------------------------


    public void addAppeal(Appeal appeal){
        Case cas=caseRepository.findCaseById(appeal.getCas().getId());
        if (cas==null)
        {    throw new APIException("Cant add Appeal without Case ");}
        else{
            appeal.setStartDate(LocalDate.now());
            appealRepository.save(appeal);
        }
    }

public void upDateAppeal(Appeal appeal,Integer id){
    Case cas=caseRepository.findCaseById(appeal.getCas().getId());

    if (cas==null)
    {    throw new APIException("Cant update Appeal without Case ");}
    else{
        Appeal appeal1=appealRepository.findAppealByCas_Id(cas.getId());
        if (appeal1==null)
        {    throw new APIException("Not found Appeal");}
        else{

            appeal1.setStartDate(appeal.getStartDate());
            appeal1.setCas(cas);
            appeal1.setTitle(appeal.getTitle());
            appeal1.setDescription(appeal.getDescription());
            appealRepository.save(appeal);
    }}
}

public void deleteAppeal(Integer id){

        if (appealRepository.findAppealByCas_Id(id)!=null){
            Appeal appeal=appealRepository.findAppealByCas_Id(id);
            appealRepository.delete(appeal);

        }else{
            throw new APIException("Not found Appeal");
        }
}



}

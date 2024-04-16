package com.example.capstone3.Service;

import com.example.capstone3.API.APIException;
import com.example.capstone3.Model.Appeal;
import com.example.capstone3.Model.Case;
import com.example.capstone3.Repositry.CaseRepository;
import com.example.capstone3.Repositry.CategoryCaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CaseService {
    private final CaseRepository caseRepository;
    private final CategoryCaseRepository categoryCaseRepository;


    public List<Case> getall() {
        if (caseRepository.findAll().isEmpty()) {
            throw new APIException("Empty Case");
        } else {
            return caseRepository.findAll();
        }
    }

    public void add(Case casse) {
        if (categoryCaseRepository.findCategoryCaseById(casse.getGategoryCases().getId()) != null) {
            casse.setStartDate(LocalDate.now());
            caseRepository.save(casse);

        }
    }

    public void upDate(Case casse, Integer id) {
        Case cas = caseRepository.findCaseById(id);
        if (cas == null) {
            throw new APIException("Not found Case with ID" + id + "or Category Not found ");
        } else if (categoryCaseRepository.findCategoryCaseById(casse.getGategoryCases().getId()) == null) {
            throw new APIException("Not found Category ");
        } else {
            cas.setStartDate(casse.getStartDate());
            cas.setAppeal(casse.isAppeal());
            cas.setAppeal(casse.getAppeal());
            cas.setGategoryCases(casse.getGategoryCases());
            caseRepository.save(cas);
        }
    }
    public void delete(Integer id) {
        Case cas = caseRepository.findCaseById(id);
        if (cas == null) {
            throw new APIException("Not found Case with ID " + id);
        }
        else{
            caseRepository.delete(cas);
        }
    }

//getStatusofCaseFrom Task from lawyer
}

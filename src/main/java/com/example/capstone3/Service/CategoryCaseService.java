package com.example.capstone3.Service;

import com.example.capstone3.API.APIException;
import com.example.capstone3.Model.Case;
import com.example.capstone3.Model.CategoryCase;
import com.example.capstone3.Repositry.CaseRepository;
import com.example.capstone3.Repositry.CategoryCaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service@RequiredArgsConstructor
public class CategoryCaseService {

    private final CategoryCaseRepository categoryCaseRepository;
private final CaseRepository caseRepository;

    public List<CategoryCase> getAll(){
        if (categoryCaseRepository.findAll().isEmpty())
        {  throw new APIException("Empty CategoryCase");}
        else{

            return categoryCaseRepository.findAll();

        }
    }

public void addCate(CategoryCase categoryCase){
        categoryCaseRepository.save(categoryCase);
}
public void updateCate(CategoryCase categoryCase,Integer id){
        if (categoryCaseRepository.findCategoryCaseById(id)!=null){
            CategoryCase categoryCase1=categoryCaseRepository.findCategoryCaseById(id);
            categoryCase1.setName(categoryCase.getName());
            categoryCase1.setCasse(categoryCase.getCasse());
            categoryCaseRepository.save(categoryCase1);
        }
        else{
            throw new APIException("Not found Category with ID"+id);

    }
}

public void deletCate(Integer id){
    if (categoryCaseRepository.findCategoryCaseById(id)!=null){
        CategoryCase categoryCase1=categoryCaseRepository.findCategoryCaseById(id);
        categoryCaseRepository.delete(categoryCase1);
    }
    else{
        throw new APIException("Not found Category with ID"+id);

    }
}


///---------------------


    public void assignCaseToCategory(Integer caseId, Integer categoryId){
        Case aCase = caseRepository.findCaseById(caseId);
        CategoryCase categoryCase = categoryCaseRepository.findCategoryCaseById(categoryId);

        if (aCase == null || categoryCase == null)
        { throw new APIException("Cannot assign case to category");}

        categoryCase.setCasse(aCase);
        categoryCaseRepository.save(categoryCase);

    }
    //----------------


}




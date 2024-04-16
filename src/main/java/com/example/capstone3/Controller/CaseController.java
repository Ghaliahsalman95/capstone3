package com.example.capstone3.Controller;
import com.example.capstone3.API.APIResponse;
import com.example.capstone3.Model.Appeal;
import com.example.capstone3.Model.Case;
import com.example.capstone3.Service.CaseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor@RestController@RequestMapping("api/v1/case")

public class CaseController {

    Logger logger =LoggerFactory.getLogger(CaseController.class);
    private final CaseService caseService;

    @GetMapping("/get-all")
    public ResponseEntity getAll(){

        logger.info("inside get-all");
        return ResponseEntity.status(HttpStatus.OK).body(caseService.getall());
    }
    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid Case casse){
        logger.info("inside add");

        caseService.add(casse);
        return ResponseEntity.status(HttpStatus.OK).body(new APIResponse("Case is added successfully"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity update(@RequestBody@Valid Case casse,@PathVariable Integer id){
        logger.info("inside update");

        caseService.upDate(casse,id);
        return ResponseEntity.status(HttpStatus.OK).body(new APIResponse("Case is updated successfully"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        logger.info("inside delete");

        caseService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(new APIResponse("Case is deleted successfully"));
    }



}

package com.example.capstone3.Controller;
import com.example.capstone3.API.APIResponse;
import com.example.capstone3.Model.Case;
import com.example.capstone3.Model.CategoryCase;
import com.example.capstone3.Service.CategoryCaseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor@RestController@RequestMapping("api/v1/category")
public class CategoryController {

    Logger logger =LoggerFactory.getLogger(CaseController.class);
    private final CategoryCaseService categoryCaseService;

    @GetMapping("/get-all")
    public ResponseEntity getAll(){

        logger.info("inside get-all");
        return ResponseEntity.status(HttpStatus.OK).body(categoryCaseService.getAll());
    }
    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid CategoryCase categoryCase){
        logger.info("inside add");

        categoryCaseService.addCate(categoryCase);
        return ResponseEntity.status(HttpStatus.OK).body(new APIResponse("category case is added successfully"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity update(@RequestBody@Valid CategoryCase categoryCase,@PathVariable Integer id){
        logger.info("inside update");

        categoryCaseService.updateCate(categoryCase,id);
        return ResponseEntity.status(HttpStatus.OK).body(new APIResponse("category is updated successfully"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        logger.info("inside delete");

        categoryCaseService.deletCate(id);
        return ResponseEntity.status(HttpStatus.OK).body(new APIResponse("category is deleted successfully"));
    }



}

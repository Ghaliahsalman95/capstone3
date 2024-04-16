package com.example.capstone3.Controller;
import com.example.capstone3.API.APIResponse;
import com.example.capstone3.Model.Appeal;
import com.example.capstone3.Service.AppealService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor@RestController@RequestMapping("api/v1/appeal")
public class AppealController {

    Logger logger =LoggerFactory.getLogger(AppealController.class);
    private final AppealService appealService;
    @GetMapping("/get-all")
    public ResponseEntity getAll(){

        logger.info("inside get-all");
        return ResponseEntity.status(HttpStatus.OK).body(appealService.getall());
    }
    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid Appeal appeal){
        logger.info("inside add");

        appealService.addAppeal(appeal);
        return ResponseEntity.status(HttpStatus.OK).body(new APIResponse("Appeal is added successfully"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity update(@RequestBody@Valid Appeal appeal,@PathVariable Integer id){
        logger.info("inside update");

        appealService.upDateAppeal(appeal,id);
        return ResponseEntity.status(HttpStatus.OK).body(new APIResponse("Appeal is updated successfully"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        logger.info("inside delete");

        appealService.deleteAppeal(id);
        return ResponseEntity.status(HttpStatus.OK).body(new APIResponse("Appeal is deleted successfully"));
    }
}

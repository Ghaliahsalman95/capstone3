package com.example.capstone3.Controller;

import com.example.capstone3.API.APIResponse;
import com.example.capstone3.DTO.DocumentDTO;
import com.example.capstone3.Service.DocumentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/document")
public class DocumentController {
    private final DocumentService documentationService;
    //   Logger logger=LoggerFactory.getLogger(ClientController.class);
    @GetMapping("/get")
    public ResponseEntity getAllDocument(){
        return ResponseEntity.status(200).body(documentationService.getAllDocuments());
    }


    @PostMapping("/add")
    public ResponseEntity addDocument(@RequestBody @Valid DocumentDTO documentDTO){
        documentationService.addDocument(documentDTO);
        return ResponseEntity.status(200).body(new APIResponse("Document added"));
    }

    @PutMapping("/update")
    public ResponseEntity updateDocument(@RequestBody @Valid DocumentDTO documentDTO){
        documentationService.updateDocument(documentDTO);
        return ResponseEntity.status(200).body(new APIResponse("Document updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteDocument(@PathVariable Integer id){
        documentationService.deleteDocument(id);
        return ResponseEntity.status(200).body(new APIResponse("Document deleted"));

    }

}

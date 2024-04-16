package com.example.capstone3.Controller;

import com.example.capstone3.API.APIResponse;
import com.example.capstone3.Model.Client;
import com.example.capstone3.Service.ClientService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/client")
public class ClientController {
    private final ClientService clientService;
    //   Logger logger=LoggerFactory.getLogger(ClientController.class);
    @GetMapping("/get")
    public ResponseEntity getAllClient(){
        return ResponseEntity.status(200).body(clientService.getAllCliet());
    }
    @PostMapping("/add")
    public ResponseEntity addClient(@RequestBody @Valid Client client){
        clientService.addClient(client);
        return ResponseEntity.status(200).body(new APIResponse("Client added"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateClient(@PathVariable Integer id,@RequestBody @Valid Client client){
        clientService.updateClient(id,client);
        return ResponseEntity.status(200).body(new APIResponse("Client updated"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteClient(@PathVariable Integer id){
        clientService.deleteClient(id);
        return ResponseEntity.status(200).body(new APIResponse("Client deleted"));
    }

}

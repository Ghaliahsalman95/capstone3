package com.example.capstone3.Service;

import com.example.capstone3.API.APIException;
import com.example.capstone3.Model.Client;
import com.example.capstone3.Repositry.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;

    public List<Client> getAllCliet(){
        return clientRepository.findAll();
    }
    public void addClient(Client client){
        clientRepository.save(client);
    }

    public void updateClient(Integer id_client,Client client){
        Client c=clientRepository.findClientById(id_client);
        if (c==null){
            throw new APIException("the client not exist");
        }
        c.setAge(client.getAge());
        c.setName(client.getName());
        c.setEmail(client.getEmail());
        c.setPhoneNumber(client.getPhoneNumber());
        clientRepository.save(c);
    }
    public void deleteClient(Integer id_client){
        Client c=clientRepository.findClientById(id_client);
        if (c==null){
            throw new APIException("the client not exist");
        }
        clientRepository.delete(c);
    }
}

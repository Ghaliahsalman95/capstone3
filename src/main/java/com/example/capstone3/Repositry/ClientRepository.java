package com.example.capstone3.Repositry;

import com.example.capstone3.Model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client,Integer> {
    Client findClientById(Integer id);
}
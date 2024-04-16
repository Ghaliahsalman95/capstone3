package com.example.capstone3.Repositry;

import com.example.capstone3.Model.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepository extends JpaRepository<Document,Integer> {
    Document findDocumentById(Integer id);
}

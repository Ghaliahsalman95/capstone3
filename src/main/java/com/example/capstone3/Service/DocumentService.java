package com.example.capstone3.Service;

import com.example.capstone3.API.APIException;
import com.example.capstone3.DTO.DocumentDTO;
import com.example.capstone3.Model.Case;
import com.example.capstone3.Model.Document;
import com.example.capstone3.Repositry.CaseRepository;
import com.example.capstone3.Repositry.DocumentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DocumentService {
    private final DocumentRepository documentationRepository;
    private final CaseRepository caseRepository;

    public List<Document> getAllDocuments(){
        return documentationRepository.findAll();
    }
    public void addDocument(DocumentDTO documentDTO){
        Case cas =caseRepository.findCaseById(documentDTO.getCase_id());
        if (cas==null){
            throw new APIException("Not found case to assign document to ");
        }
        Document  doc=new Document(null, documentDTO.getTitle(), documentDTO.getDescription(), documentDTO.getFilePath(),cas);
        documentationRepository.save(doc);
    }
    public void updateDocument(DocumentDTO documentDTO){
        Document doc=documentationRepository.findDocumentById(documentDTO.getCase_id());
        if (doc==null){
            throw new APIException("Not found document");
        }
        doc.setDescription(documentDTO.getDescription());
        doc.setTitle(documentDTO.getTitle());
        doc.setFilePath(documentDTO.getFilePath());
        documentationRepository.save(doc);
    }

    public void deleteDocument(Integer id){
        Document doc=documentationRepository.findDocumentById(id);
        if (doc==null){
            throw new APIException("Not found document");
        }
        documentationRepository.delete(doc);
    }
}

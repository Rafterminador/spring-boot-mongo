package com.theonlyfer.springbootmongoapp.services.impl;

import com.theonlyfer.springbootmongoapp.dto.DocumentDTO;
import com.theonlyfer.springbootmongoapp.model.IdentityDocument;
import com.theonlyfer.springbootmongoapp.repository.IdentityDocumentRepository;
import com.theonlyfer.springbootmongoapp.services.IdentityDocumentService;
import com.theonlyfer.springbootmongoapp.utils.DocumentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IdentityDocumentServiceImp implements IdentityDocumentService {
    @Autowired
    private IdentityDocumentRepository identityDocumentRepository;

    @Override
    public String createDocument(IdentityDocument identityDocument){
        Optional<IdentityDocument> identityDocumentAux =  identityDocumentRepository.findByNumberAndIsActiveTrue(identityDocument.getNumber());
        if (identityDocumentAux.isPresent()) {
            throw new DocumentNotFoundException("Identity document with the same number, has already created", HttpStatus.CONFLICT);
        }
        identityDocument.setIsActive(Boolean.TRUE);
        identityDocumentRepository.save(identityDocument);
        return "Document created";
    }

    @Override
    public List<IdentityDocument> getAllIdentityDocument(){
        return identityDocumentRepository.findByIsActiveTrue();
    }

    @Override
    public String updateDocument(DocumentDTO documentDTO, String number){
        Optional<IdentityDocument> identityDocument =  identityDocumentRepository.findByNumberAndIsActiveTrue(number);
        if (identityDocument.isPresent()) {
            if(documentDTO.getEmissionDate() != null) {
                identityDocument.get().setEmissionDate(documentDTO.getEmissionDate());
            }
            if(documentDTO.getExpiryDate() != null) {
                identityDocument.get().setExpiryDate(documentDTO.getExpiryDate());
            }
            identityDocumentRepository.save(identityDocument.get());
        } else {
            throw new DocumentNotFoundException("Document not found", HttpStatus.NOT_FOUND);
        }
        return "Document updated correctly";
    }

    @Override
    public String deleteDocument(String number){
        Optional<IdentityDocument> identityDocument = identityDocumentRepository.findByNumberAndIsActiveTrue(number);
        if (identityDocument.isPresent()) {
            identityDocument.get().setIsActive(Boolean.FALSE);
            identityDocumentRepository.save(identityDocument.get());
        } else {
            throw new DocumentNotFoundException("Document not found: " + number, HttpStatus.NOT_FOUND);
        }
        return "Deleted document: " + number;
    }
}

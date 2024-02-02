package com.theonlyfer.springbootmongoapp.services.impl;

import com.theonlyfer.springbootmongoapp.model.IdentityDocument;
import com.theonlyfer.springbootmongoapp.repository.IdentityDocumentRepository;
import com.theonlyfer.springbootmongoapp.services.IdentityDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IdentityDocumentServiceImp implements IdentityDocumentService {
    @Autowired
    private IdentityDocumentRepository identityDocumentRepository;

    @Override
    public String createPerson(IdentityDocument identityDocument){
        identityDocumentRepository.save(identityDocument);
        return "Document created";
    }
}

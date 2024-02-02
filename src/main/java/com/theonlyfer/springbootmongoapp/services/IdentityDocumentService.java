package com.theonlyfer.springbootmongoapp.services;

import com.theonlyfer.springbootmongoapp.dto.DocumentDTO;
import com.theonlyfer.springbootmongoapp.model.IdentityDocument;

import java.util.List;

public interface IdentityDocumentService {
    public String createDocument(IdentityDocument identityDocument);

    public List<IdentityDocument> getAllIdentityDocument();

    public String updateDocument(DocumentDTO documentDTO, String number);

    public String deleteDocument(String number);
}

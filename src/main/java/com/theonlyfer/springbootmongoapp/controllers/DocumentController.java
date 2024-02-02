package com.theonlyfer.springbootmongoapp.controllers;

import com.theonlyfer.springbootmongoapp.dto.DocumentDTO;
import com.theonlyfer.springbootmongoapp.model.IdentityDocument;
import com.theonlyfer.springbootmongoapp.services.IdentityDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/document")
public class DocumentController {

    @Autowired
    private IdentityDocumentService identityDocumentService;

    @GetMapping(value = "/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("OK");
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<IdentityDocument>> getAllIdentityDocument() {
        List<IdentityDocument> response = identityDocumentService.getAllIdentityDocument();
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<String> createDocument(@RequestBody IdentityDocument identityDocument){
        String response = identityDocumentService.createDocument(identityDocument);
        return ResponseEntity.ok(response);
    }

    @PutMapping(value = "/update/{number}")
    public ResponseEntity<String> updateIdentityDocument(@RequestBody DocumentDTO documentDTO, @PathVariable String number){
        String response = identityDocumentService.updateDocument(documentDTO, number);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping(value = "/delete/{number}")
    public ResponseEntity<String> deleteDocument(@PathVariable String number){
        String response = identityDocumentService.deleteDocument(number);
        return ResponseEntity.ok(response);
    }
}

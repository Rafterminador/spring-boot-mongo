package com.theonlyfer.springbootmongoapp.controllers;

import com.theonlyfer.springbootmongoapp.model.IdentityDocument;
import com.theonlyfer.springbootmongoapp.services.IdentityDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/document")
public class DocumentController {

    @Autowired
    private IdentityDocumentService identityDocumentService;

    @GetMapping(value = "/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("OK");
    }

    @PostMapping(value = "/create")
    public ResponseEntity<String> createPerson(@RequestBody IdentityDocument identityDocument){
        String response = identityDocumentService.createPerson(identityDocument);
        return ResponseEntity.ok(response);
    }
}

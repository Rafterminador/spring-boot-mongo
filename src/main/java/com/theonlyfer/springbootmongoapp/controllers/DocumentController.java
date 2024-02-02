package com.theonlyfer.springbootmongoapp.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/document")
public class DocumentController {
    @GetMapping(value="/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("OK");
    }
}

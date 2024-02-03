package com.theonlyfer.springbootmongoapp.controllers;

import com.theonlyfer.springbootmongoapp.dto.TokenDTO;
import com.theonlyfer.springbootmongoapp.model.User;
import com.theonlyfer.springbootmongoapp.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping
    public ResponseEntity<TokenDTO> login (@RequestBody User user) {
        TokenDTO response = loginService.login(user);
        return ResponseEntity.ok(response);
    }
}

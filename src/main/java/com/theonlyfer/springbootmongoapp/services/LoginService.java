package com.theonlyfer.springbootmongoapp.services;

import com.theonlyfer.springbootmongoapp.dto.TokenDTO;
import com.theonlyfer.springbootmongoapp.model.User;

public interface LoginService {
    public TokenDTO login(User user);
}

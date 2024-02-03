package com.theonlyfer.springbootmongoapp.services.impl;

import com.theonlyfer.springbootmongoapp.dto.TokenDTO;
import com.theonlyfer.springbootmongoapp.model.User;
import com.theonlyfer.springbootmongoapp.repository.UserRepository;
import com.theonlyfer.springbootmongoapp.services.LoginService;
import com.theonlyfer.springbootmongoapp.utils.DocumentNotFoundException;
import com.theonlyfer.springbootmongoapp.utils.EncryptUtil;
import com.theonlyfer.springbootmongoapp.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginServiceImp implements LoginService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private EncryptUtil encryptUtil;

    @Override
    public TokenDTO login(User user) throws Exception{
        Optional<User> loginUser = userRepository.findByUserAndPasswordAndIsActiveTrue(user.getUser(), encryptUtil.encrypt(user.getPassword()));
        if (loginUser.isPresent()){
            return TokenDTO.builder().token(jwtUtil.generateToken(user.getUser())).build();
        } else {
            throw new DocumentNotFoundException("Unauthorized", HttpStatus.UNAUTHORIZED);
        }
    }
}

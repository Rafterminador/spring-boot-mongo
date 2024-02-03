package com.theonlyfer.springbootmongoapp.repository;

import com.theonlyfer.springbootmongoapp.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository  extends MongoRepository<User, String> {
    Optional<User> findByUserAndPasswordAndIsActiveTrue(String user, String password);
}

package com.theonlyfer.springbootmongoapp.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection  = "user")
public class User {
    private String user;
    private String password;
}

package com.theonlyfer.springbootmongoapp.dto;

import lombok.Data;

import java.util.Date;

@Data
public class DocumentDTO {
    private String expiryDate;
    private Date emissionDate;
}

package com.theonlyfer.springbootmongoapp.model;

import com.theonlyfer.springbootmongoapp.dto.DocumentType;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Data
@Document(collection = "identityDocument")
public class IdentityDocument {
    @Id
    private String number;
    private String expiryDate;
    private Date emissionDate;
    private DocumentType documentType;
    private Boolean isActive;
}

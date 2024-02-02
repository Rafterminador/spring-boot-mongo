package com.theonlyfer.springbootmongoapp.repository;

import com.theonlyfer.springbootmongoapp.model.IdentityDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IdentityDocumentRepository  extends MongoRepository<IdentityDocument, String> {
    List<IdentityDocument> findByIsActiveTrue();
}

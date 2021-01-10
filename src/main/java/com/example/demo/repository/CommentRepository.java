package com.example.demo.repository;

import com.example.demo.model.domain.CommentDomain;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CommentRepository extends MongoRepository <CommentDomain, String> {
}

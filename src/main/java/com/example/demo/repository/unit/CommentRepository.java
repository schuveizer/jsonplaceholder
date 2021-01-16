package com.example.demo.repository.unit;

import com.example.demo.model.domain.unit.CommentDomain;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CommentRepository extends MongoRepository <CommentDomain, String> {
}

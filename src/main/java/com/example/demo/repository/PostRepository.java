package com.example.demo.repository;

import com.example.demo.model.domain.PostDomain;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface PostRepository extends MongoRepository <PostDomain, String> {
}

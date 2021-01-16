package com.example.demo.repository;

import com.example.demo.model.domain.completeuser.CompleteUserDomain;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CompleteUserRepository extends MongoRepository <CompleteUserDomain, String> {
}

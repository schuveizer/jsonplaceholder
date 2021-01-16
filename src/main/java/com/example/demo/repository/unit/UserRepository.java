package com.example.demo.repository.unit;


import com.example.demo.model.domain.unit.user.UserDomain;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface UserRepository extends MongoRepository <UserDomain, String> {
}

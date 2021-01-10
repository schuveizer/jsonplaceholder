package com.example.demo.repository;

import com.example.demo.model.domain.TodoDomain;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface TodoRepository extends MongoRepository <TodoDomain, String> {

}

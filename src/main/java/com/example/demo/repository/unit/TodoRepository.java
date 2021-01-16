package com.example.demo.repository.unit;

import com.example.demo.model.domain.unit.TodoDomain;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface TodoRepository extends MongoRepository <TodoDomain, String> {

}

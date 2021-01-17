package com.example.demo.repository.unit;

import com.example.demo.model.domain.unit.TodoDomain;
import com.example.demo.repository.unit.template.TodoTemplateRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface TodoRepository extends MongoRepository <TodoDomain, String>, TodoTemplateRepository {

    List<TodoDomain> findByUserId (String userId);

}

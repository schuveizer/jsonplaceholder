package com.example.demo.repository.unit.template.impl;

import com.example.demo.model.domain.unit.TodoDomain;
import com.example.demo.model.domain.unit.user.UserDomain;
import com.example.demo.repository.unit.template.TodoTemplateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;

@RequiredArgsConstructor

public class TodoTemplateRepositoryImpl implements TodoTemplateRepository {

    private final MongoTemplate mongoTemplate;

    @Override
    public List<TodoDomain> getTodoByBoolean(Boolean completed) {
        Query query = new Query();
        Criteria criteria = where("completed").is(completed);
        query.addCriteria(criteria);
        return mongoTemplate.find(query, TodoDomain.class);
    }
}

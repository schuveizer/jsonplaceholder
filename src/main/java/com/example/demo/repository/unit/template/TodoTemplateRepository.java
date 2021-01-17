package com.example.demo.repository.unit.template;

import com.example.demo.model.domain.unit.TodoDomain;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface TodoTemplateRepository {

    List<TodoDomain> getTodoByBoolean (Boolean completed);

}

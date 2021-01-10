package com.example.demo.utils.db;

import com.example.demo.model.domain.TodoDomain;
import com.example.demo.model.request.TodoRequest;
import com.example.demo.model.response.TodoResponse;
import org.springframework.stereotype.Component;

@Component

public class ConverterTodoDB {

    public static TodoDomain convertTodoRequestToDomain (TodoRequest todo){
        return TodoDomain.builder()
                .userId(todo.getUserId())
                .title(todo.getTitle())
                .completed(todo.getCompleted())
                .build();
    }

    public static TodoResponse convertTodoDomainToResponse (TodoDomain todo){
        return TodoResponse.builder()
                .id(todo.getId())
                .userId(todo.getUserId())
                .title(todo.getTitle())
                .completed(todo.getCompleted())
                .build();
    }
}

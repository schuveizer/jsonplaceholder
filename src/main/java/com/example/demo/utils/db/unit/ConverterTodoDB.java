package com.example.demo.utils.db.unit;

import com.example.demo.model.domain.completeuser.CompleteUserTodoDomain;
import com.example.demo.model.domain.unit.TodoDomain;
import com.example.demo.model.gateway.TodoGateway;
import com.example.demo.model.request.unit.TodoRequest;
import com.example.demo.model.response.unit.TodoResponse;
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

    public static TodoDomain convertTodoGatewayToDomain (TodoGateway todo) {
        return TodoDomain.builder()
                .title(todo.getTitle())
                .completed(todo.getCompleted())
                .build();
    }

    public static TodoDomain convertTodoGatewayToDomainWithUserId (TodoGateway todo, String userId) {
        return TodoDomain.builder()
                .userId(userId)
                .title(todo.getTitle())
                .completed(todo.getCompleted())
                .build();
    }
}

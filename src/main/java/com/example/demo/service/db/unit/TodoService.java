package com.example.demo.service.db.unit;

import com.example.demo.model.domain.unit.TodoDomain;
import com.example.demo.model.domain.unit.user.UserDomain;
import com.example.demo.model.request.unit.TodoRequest;
import com.example.demo.model.response.unit.TodoResponse;
import com.example.demo.repository.unit.TodoRepository;
import com.example.demo.repository.unit.UserRepository;
import com.example.demo.utils.db.unit.ConverterTodoDB;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class TodoService {

    private final TodoRepository todoRepository;
    private final UserRepository userRepository;

    public List<TodoResponse> getAll (){
        List<TodoDomain> todos = todoRepository.findAll();
        return todos.stream().map(ConverterTodoDB::convertTodoDomainToResponse)
                .collect(Collectors.toList());
    }

    public TodoResponse getById (String id){
        TodoDomain todo = todoRepository.findById(id).orElseThrow();
        return ConverterTodoDB.convertTodoDomainToResponse(todo);
    }

    public TodoResponse create (TodoRequest request){
        userRepository.findById(request.getUserId()).orElseThrow();
        TodoDomain todo = ConverterTodoDB.convertTodoRequestToDomain(request);
        todo = todoRepository.insert(todo);
        return ConverterTodoDB.convertTodoDomainToResponse(todo);
    }

    public TodoResponse update (TodoRequest request, String id){
        userRepository.findById(request.getUserId()).orElseThrow();
        getById(id);
        TodoDomain todo = ConverterTodoDB.convertTodoRequestToDomain(request);
        todo.setId(id);
        todo = todoRepository.save(todo);
        return ConverterTodoDB.convertTodoDomainToResponse(todo);
    }

    public void delete (String id){
        getById(id);
        todoRepository.deleteById(id);
    }

    public List<TodoDomain> fullLoad(List<TodoDomain> todos){
        return todoRepository.saveAll(todos);
    }

    public void purgeDB(){
        todoRepository.deleteAll();
    }
}

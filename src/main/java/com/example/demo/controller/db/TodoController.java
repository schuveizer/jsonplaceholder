package com.example.demo.controller.db;

import com.example.demo.model.request.TodoRequest;
import com.example.demo.model.response.TodoResponse;
import com.example.demo.service.db.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping ("/db/todo")

public class TodoController {

    private final TodoService todoService;

    @GetMapping
    public List<TodoResponse> getAll(){
        return todoService.getAll();
    }

    @GetMapping ("/{id}")
    public TodoResponse getById (@PathVariable String id){
        return todoService.getById(id);
    }

    @PostMapping
    public TodoResponse create (@Valid @RequestBody TodoRequest request){
        return todoService.create(request);
    }

    @PutMapping ("/{id}")
    public TodoResponse update (@RequestBody TodoRequest request, @PathVariable String id){
        return todoService.update(request, id);
    }

    @DeleteMapping ("/{id}")
    public void delete (@PathVariable String id){
        todoService.delete(id);
    }

}

package com.example.demo.controller.db.unit;

import com.example.demo.model.request.unit.TodoRequest;
import com.example.demo.model.response.unit.TodoResponse;
import com.example.demo.service.db.unit.TodoService;
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
    public List<TodoResponse> getAll(@RequestParam (required = false) String userId){
        return todoService.getAll(userId);
    }

    @GetMapping ("/completed")
    public List<TodoResponse> getAll(@RequestParam Boolean completed){
        return todoService.getByBoolean(completed);
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

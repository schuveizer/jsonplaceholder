package com.example.demo.controller.db.unit;

import com.example.demo.model.request.unit.CommentRequest;
import com.example.demo.model.response.unit.CommentResponse;
import com.example.demo.service.db.unit.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping ("/db/comment")

public class CommentController {

    private final CommentService commentService;

    @GetMapping
    public List<CommentResponse> getAll(){
        return commentService.getAll();
    }

    @GetMapping ("/{id}")
    public CommentResponse getById (@PathVariable String id){
        return commentService.getById(id);
    }

    @PostMapping
    public CommentResponse create (@Valid @RequestBody CommentRequest request){
        return commentService.create(request);
    }

    @PutMapping ("/{id}")
    public CommentResponse update (@RequestBody CommentRequest request, @PathVariable String id){
        return commentService.update(request, id);
    }

    @DeleteMapping ("/{id}")
    public void delete (@PathVariable String id){
        commentService.delete(id);
    }
}

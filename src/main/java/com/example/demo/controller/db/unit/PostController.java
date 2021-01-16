package com.example.demo.controller.db.unit;

import com.example.demo.model.request.unit.PostRequest;
import com.example.demo.model.response.unit.PostResponse;
import com.example.demo.service.db.unit.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping ("/db/post")

public class PostController {
    
    private final PostService postService;
    
    @GetMapping
    public List<PostResponse> getAll (){
        return postService.getAll();
    }

    @GetMapping ("/{id}")
    public PostResponse getById (@PathVariable String id){
        return postService.getById(id);
    }

    @PostMapping
    public PostResponse create (@Valid @RequestBody PostRequest request){
        return  postService.create(request);
    }

    @PutMapping ("/{id}")
    public PostResponse update (@RequestBody PostRequest request, @PathVariable String id){
        return postService.update(request, id);
    }

    @DeleteMapping ("/{id}")
    public void delete (@PathVariable String id){
        postService.delete(id);
    }

}

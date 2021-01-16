package com.example.demo.controller.db;

import com.example.demo.model.request.CompleteUserRequest;
import com.example.demo.model.response.CompleteUserResponse;
import com.example.demo.service.db.CompleteUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping ("/db/completeuser")

public class CompleteUserController {

    private final CompleteUserService completeUserService;

    @GetMapping
    public List<CompleteUserResponse> getAll (){
        return completeUserService.getAll();
    }

    @GetMapping ("/{id}")
    public CompleteUserResponse getById (@PathVariable String id){
        return completeUserService.getById(id);
    }

    @PostMapping
    public CompleteUserResponse create (@RequestBody CompleteUserRequest user){
        return completeUserService.create(user);
    }

    @PutMapping ("/{id}")
    public CompleteUserResponse update (@RequestBody CompleteUserRequest user,
                                        @PathVariable String id){
        return completeUserService.update(user, id);
    }

    @DeleteMapping ("/{id}")
    public void delete (@PathVariable String id){
        completeUserService.delete(id);
    }

    @PostMapping("/full-load")
    public  void fullLoad (){
        completeUserService.fullLoad();
    }

    @DeleteMapping("/purge")
    public void purgeDB(){
        completeUserService.purgeDB();
    }

}

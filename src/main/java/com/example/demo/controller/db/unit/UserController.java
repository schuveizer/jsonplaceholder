package com.example.demo.controller.db.unit;

import com.example.demo.model.domain.completeuser.CompleteUserDomain;
import com.example.demo.model.request.unit.UserRequest;
import com.example.demo.model.response.CompleteUserResponse;
import com.example.demo.model.response.unit.UserResponse;
import com.example.demo.service.db.unit.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping ("/db/user")

public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserResponse> getAll (@RequestParam (required = false) String name){
        return userService.getAll(name);
    }

    @GetMapping ("/geo")
    public List<UserResponse> getByLatLngRange (@RequestParam Double minLat,
                                                @RequestParam Double maxLat,
                                                @RequestParam Double minLng,
                                                @RequestParam Double maxLng){
        return userService.getByLatLngRange(minLat,maxLat,minLng,maxLng);
    }

    @GetMapping ("/dumb")
    public List<CompleteUserDomain> getDumbCompleteUser (){
        return userService.getDumbCompleteUser();
    }

    @GetMapping ("/{id}")
    public UserResponse getById (@PathVariable String id){
        return userService.getById(id);
    }

    @PostMapping
    public UserResponse create (@RequestBody UserRequest user){
        return userService.create(user);
    }

    @PutMapping ("/{id}")
    public UserResponse update (@RequestBody UserRequest user,
                                @PathVariable String id){
        return userService.update(user, id);
    }

    @DeleteMapping ("/{id}")
    public void delete (@PathVariable String id){
        userService.delete(id);
    }

}

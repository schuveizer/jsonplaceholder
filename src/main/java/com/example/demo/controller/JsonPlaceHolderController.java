package com.example.demo.controller;

import com.example.demo.model.gateway.response.AlbumResponseGateway;
import com.example.demo.model.gateway.response.PostResponseGateway;
import com.example.demo.model.gateway.response.UserResponseGateway;
import com.example.demo.service.JsonPlaceHolderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/complete")

public class JsonPlaceHolderController {

    private final JsonPlaceHolderService jsonService;

    @GetMapping ("/post")
    public List<PostResponseGateway> getCompletePostResponse () {
        return jsonService.getCompletePost();
    }

    @GetMapping ("/album")
    public List<AlbumResponseGateway> getCompleteAlbumResponse (){
        return jsonService.getCompleteAlbum();
    }

    @GetMapping ("/user")
    public List<UserResponseGateway> getCompleteUserResponse(){
        return jsonService.getcompleteUser();
    }

    @GetMapping ("/userbyid")
    public UserResponseGateway getUserById(@RequestParam Integer id){
        return jsonService.getSpecificUser(id);
    }
}

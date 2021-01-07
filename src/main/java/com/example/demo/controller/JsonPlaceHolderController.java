package com.example.demo.controller;

import com.example.demo.model.jsonplaceholder.response.AlbumResponse;
import com.example.demo.model.jsonplaceholder.response.PostResponse;
import com.example.demo.model.jsonplaceholder.response.UserResponse;
import com.example.demo.service.JsonPlaceHolderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/complete")

public class JsonPlaceHolderController {

    private final JsonPlaceHolderService jsonService;

    @GetMapping ("/post")
    public List<PostResponse> getCompletePostResponse () {
        return jsonService.getCompletePost();
    }

    @GetMapping ("/album")
    public List<AlbumResponse> getCompleteAlbumResponse (){
        return jsonService.getCompleteAlbum();
    }

    @GetMapping ("/user")
    public List<UserResponse> getCompleteUserResponse(){
        return jsonService.getcompleteUser();
    }
}

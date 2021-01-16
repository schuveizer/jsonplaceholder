package com.example.demo.controller;

import com.example.demo.model.gateway.completeuser.CompleteUserAlbumGateway;
import com.example.demo.model.gateway.completeuser.CompleteUserPostGateway;
import com.example.demo.model.gateway.completeuser.CompleteUserGateway;
import com.example.demo.service.GatewayService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/complete")

public class GatewayController {

    private final GatewayService jsonService;

    @GetMapping ("/post")
    public List<CompleteUserPostGateway> getCompletePostResponse () {
        return jsonService.getCompletePost();
    }

    @GetMapping ("/album")
    public List<CompleteUserAlbumGateway> getCompleteAlbumResponse (){
        return jsonService.getCompleteAlbum();
    }

    @GetMapping ("/user")
    public List<CompleteUserGateway> getCompleteUserResponse(){
        return jsonService.getCompleteUser();
    }

    @GetMapping ("/userbyid")
    public CompleteUserGateway getUserById(@RequestParam Integer id){
        return jsonService.getSpecificUser(id);
    }
}

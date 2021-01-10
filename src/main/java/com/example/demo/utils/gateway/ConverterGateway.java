package com.example.demo.utils.gateway;

import com.example.demo.model.gateway.*;
import com.example.demo.model.gateway.response.AlbumResponseGateway;
import com.example.demo.model.gateway.response.PostResponseGateway;
import com.example.demo.model.gateway.response.UserResponseGateway;
import com.example.demo.model.gateway.user.UserGateway;
import org.springframework.stereotype.Component;

import java.util.List;

@Component

public class ConverterGateway {

    public static UserResponseGateway convertUser (UserGateway userGateway, List<AlbumResponseGateway> albums, List<PostResponseGateway> posts, List<TodoGateway> todoGateways) {
        return   UserResponseGateway.builder()
                .id(userGateway.getId())
                .name(userGateway.getName())
                .username(userGateway.getUsername())
                .email(userGateway.getEmail())
                .address(userGateway.getAddress())
                .phone(userGateway.getPhone())
                .website(userGateway.getWebsite())
                .company(userGateway.getCompany())
                .posts(posts)
                .albums(albums)
                .todoGateways(todoGateways)
                .build();
    }

    public static AlbumResponseGateway convertAlbum (AlbumGateway albumGateway, List<PhotoGateway> photoGateways){
        return AlbumResponseGateway.builder()
                .userId(albumGateway.getUserId())
                .id(albumGateway.getId())
                .title(albumGateway.getTitle())
                .photoGateways(photoGateways)
                .build();
    }

    public static PostResponseGateway convertPost (PostGateway postGateway, List<CommentGateway> commentGateways){
        return PostResponseGateway.builder()
                .userId(postGateway.getUserId())
                .id(postGateway.getId())
                .title(postGateway.getTitle())
                .body(postGateway.getBody())
                .commentGateways(commentGateways)
                .build();
    }

}

package com.example.demo.utils.gateway;

import com.example.demo.model.gateway.*;
import com.example.demo.model.gateway.completeuser.CompleteUserAlbumGateway;
import com.example.demo.model.gateway.completeuser.CompleteUserPostGateway;
import com.example.demo.model.gateway.completeuser.CompleteUserGateway;
import com.example.demo.model.gateway.user.UserGateway;
import org.springframework.stereotype.Component;

import java.util.List;

@Component

public class ConverterGateway {

    public static CompleteUserGateway convertUser (UserGateway userGateway,
                                                   List<CompleteUserAlbumGateway> albums,
                                                   List<CompleteUserPostGateway> posts,
                                                   List<TodoGateway> todos) {
        return   CompleteUserGateway.builder()
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
                .todos(todos)
                .build();
    }

    public static CompleteUserAlbumGateway convertAlbum (AlbumGateway albumGateway,
                                                         List<PhotoGateway> photoGateways){
        return CompleteUserAlbumGateway.builder()
                .userId(albumGateway.getUserId())
                .id(albumGateway.getId())
                .title(albumGateway.getTitle())
                .photos(photoGateways)
                .build();
    }

    public static CompleteUserPostGateway convertPost (PostGateway postGateway,
                                                       List<CommentGateway> commentGateways){
        return CompleteUserPostGateway.builder()
                .userId(postGateway.getUserId())
                .id(postGateway.getId())
                .title(postGateway.getTitle())
                .body(postGateway.getBody())
                .comments(commentGateways)
                .build();
    }
}

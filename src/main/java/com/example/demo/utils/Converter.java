package com.example.demo.utils;

import com.example.demo.model.jsonplaceholder.*;
import com.example.demo.model.jsonplaceholder.response.AlbumResponse;
import com.example.demo.model.jsonplaceholder.response.PostResponse;
import com.example.demo.model.jsonplaceholder.response.UserResponse;
import com.example.demo.model.jsonplaceholder.user.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component

public class Converter {

    public static UserResponse convertUser (User user, List<AlbumResponse> albums, List<PostResponse> posts, List<Todo> todos) {
        return   UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .username(user.getUsername())
                .email(user.getEmail())
                .address(user.getAddress())
                .phone(user.getPhone())
                .website(user.getWebsite())
                .company(user.getCompany())
                .posts(posts)
                .albums(albums)
                .todos(todos)
                .build();
    }

    public static AlbumResponse convertAlbum (Album album, List<Photo> photos){
        return AlbumResponse.builder()
                .userId(album.getUserId())
                .id(album.getId())
                .title(album.getTitle())
                .photos(photos)
                .build();
    }

    public static PostResponse convertPost (Post post, List<Comment> comments){
        return PostResponse.builder()
                .userId(post.getUserId())
                .id(post.getId())
                .title(post.getTitle())
                .body(post.getBody())
                .comments(comments)
                .build();
    }

}

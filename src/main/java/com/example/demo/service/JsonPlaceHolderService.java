package com.example.demo.service;

import com.example.demo.model.jsonplaceholder.*;
import com.example.demo.model.jsonplaceholder.response.AlbumResponse;
import com.example.demo.model.jsonplaceholder.response.PostResponse;
import com.example.demo.model.jsonplaceholder.response.UserResponse;
import com.example.demo.model.jsonplaceholder.user.User;
import com.example.demo.repository.JsonPlaceHolderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class JsonPlaceHolderService {

    private final JsonPlaceHolderRepository jsonPlaceHolderRepository;

    public List<PostResponse> getCompletePost (){
        List<Post> posts = jsonPlaceHolderRepository.getPosts();
        List<Comment> comments = jsonPlaceHolderRepository.getComments();
        List<PostResponse> responsePost = posts.stream().map(post -> {
            List<Comment> filteredComments = comments.stream()
                    .filter(comment -> comment.getPostId().equals(post.getId()))
                    .collect(Collectors.toList());
            return PostResponse.builder()
                    .userId(post.getUserId())
                    .id(post.getId())
                    .title(post.getTitle())
                    .body(post.getBody())
                    .comments(filteredComments)
                    .build();
        }).collect(Collectors.toList());
        return responsePost;
    }

    public List<AlbumResponse> getCompleteAlbum(){
        List<Album> albums = jsonPlaceHolderRepository.getAlbums();
        List<Photo> photos = jsonPlaceHolderRepository.getPhotos();
        List<AlbumResponse> responseAlbum = albums.stream().map(album ->{
            List<Photo> filteredPhotos = photos.stream()
                    .filter(photo -> photo.getAlbumId().equals(album.getId()))
                    .collect(Collectors.toList());
            return AlbumResponse.builder()
                    .userId(album.getUserId())
                    .id(album.getId())
                    .title(album.getTitle())
                    .photos(filteredPhotos)
                    .build();
        }).collect(Collectors.toList());
        return responseAlbum;
    };

    public List<UserResponse> getcompleteUser(){
        List<User> users = jsonPlaceHolderRepository.getUsers();
        List<Todo> todos = jsonPlaceHolderRepository.getTodos();
        List<AlbumResponse> albums = getCompleteAlbum();
        List<PostResponse> posts = getCompletePost();
        List<UserResponse> responseUser = users.stream().map(user -> {
            List<Todo> filteredTodo = todos.stream()
                    .filter(todo -> todo.getUserId().equals(user.getId()))
                    .collect(Collectors.toList());
            List<AlbumResponse> filteredAlbum = albums.stream()
                    .filter(albumResponse -> albumResponse.getUserId().equals(user.getId()))
                    .collect(Collectors.toList());
            List<PostResponse> filteredPost = posts.stream()
                    .filter(postResponse -> postResponse.getUserId().equals(user.getId()))
                    .collect(Collectors.toList());
            return UserResponse.builder()
                    .id(user.getId())
                    .name(user.getName())
                    .username(user.getUsername())
                    .email(user.getEmail())
                    .address(user.getAddress())
                    .phone(user.getPhone())
                    .website(user.getWebsite())
                    .company(user.getCompany())
                    .posts(filteredPost)
                    .albums(filteredAlbum)
                    .todos(filteredTodo)
                    .build();
        }).collect(Collectors.toList());
        return responseUser;
    };
}

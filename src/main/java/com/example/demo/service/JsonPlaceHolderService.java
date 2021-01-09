package com.example.demo.service;

import com.example.demo.model.jsonplaceholder.*;
import com.example.demo.model.jsonplaceholder.response.AlbumResponse;
import com.example.demo.model.jsonplaceholder.response.PostResponse;
import com.example.demo.model.jsonplaceholder.response.UserResponse;
import com.example.demo.model.jsonplaceholder.user.User;
import com.example.demo.repository.JsonPlaceHolderRepository;
import com.example.demo.utils.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor

public class JsonPlaceHolderService {

    private final JsonPlaceHolderRepository jsonPlaceHolderRepository;

    public List<PostResponse> getCompletePost (){
        List<Post> posts = jsonPlaceHolderRepository.getPosts();
        List<Comment> comments = jsonPlaceHolderRepository.getComments();
        List<PostResponse> responsePost = Mapper.mapToPostResponseList(posts, comments);
        return responsePost;
    }

    public List<AlbumResponse> getCompleteAlbum(){
        List<Album> albums = jsonPlaceHolderRepository.getAlbums();
        List<Photo> photos = jsonPlaceHolderRepository.getPhotos();
        List<AlbumResponse> responseAlbum = Mapper.mapToAlbumResponseList(albums, photos);
        return responseAlbum;
    };

    public List<UserResponse> getcompleteUser(){
        List<User> users = jsonPlaceHolderRepository.getUsers();
        List<Todo> todos = jsonPlaceHolderRepository.getTodos();
        List<AlbumResponse> albums = getCompleteAlbum();
        List<PostResponse> posts = getCompletePost();
        List<UserResponse> responseUser = Mapper.mapToUserResponseList(users, todos, albums, posts);
        return responseUser;
    };

    public UserResponse getSpecificUser (Integer id){
        User user = jsonPlaceHolderRepository.getUserById(id).stream().findFirst().orElse(null);
        if(Objects.isNull(user))
            return null;

        List<Post> posts = jsonPlaceHolderRepository.getPostByUserId(id);
        List<Comment> comments = jsonPlaceHolderRepository.getComments();
        List<Album> albums = jsonPlaceHolderRepository.getAlbumByUserId(id);
        List<Photo> photos = jsonPlaceHolderRepository.getPhotos();
        List<Todo> todos = jsonPlaceHolderRepository.getTodoByUserId(id);

        List<AlbumResponse> responseAlbum = Mapper.mapToAlbumResponseList(albums, photos);

        List<PostResponse> responsePost = Mapper.mapToPostResponseList(posts, comments);

        return Mapper.mapToUserResponse(user, todos, responseAlbum, responsePost);
//        return jsonPlaceHolderRepository.getSpecificUser(id).stream().findFirst().orElse(null);
    }
}

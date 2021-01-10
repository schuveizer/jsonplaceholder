package com.example.demo.service;

import com.example.demo.model.gateway.*;
import com.example.demo.model.gateway.response.AlbumResponseGateway;
import com.example.demo.model.gateway.response.PostResponseGateway;
import com.example.demo.model.gateway.response.UserResponseGateway;
import com.example.demo.model.gateway.user.UserGateway;
import com.example.demo.repository.JsonPlaceHolderRepository;
import com.example.demo.utils.gateway.MapperGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor

public class JsonPlaceHolderService {

    private final JsonPlaceHolderRepository jsonPlaceHolderRepository;

    public List<PostResponseGateway> getCompletePost (){
        List<PostGateway> postGateways = jsonPlaceHolderRepository.getPosts();
        List<CommentGateway> commentGateways = jsonPlaceHolderRepository.getComments();
        List<PostResponseGateway> responsePost = MapperGateway.mapToPostResponseList(postGateways, commentGateways);
        return responsePost;
    }

    public List<AlbumResponseGateway> getCompleteAlbum(){
        List<AlbumGateway> albumGateways = jsonPlaceHolderRepository.getAlbums();
        List<PhotoGateway> photoGateways = jsonPlaceHolderRepository.getPhotos();
        List<AlbumResponseGateway> responseAlbum = MapperGateway.mapToAlbumResponseList(albumGateways, photoGateways);
        return responseAlbum;
    };

    public List<UserResponseGateway> getcompleteUser(){
        List<UserGateway> userGateways = jsonPlaceHolderRepository.getUsers();
        List<TodoGateway> todoGateways = jsonPlaceHolderRepository.getTodos();
        List<AlbumResponseGateway> albums = getCompleteAlbum();
        List<PostResponseGateway> posts = getCompletePost();
        List<UserResponseGateway> responseUser = MapperGateway.mapToUserResponseList(userGateways, todoGateways, albums, posts);
        return responseUser;
    };

    public UserResponseGateway getSpecificUser (Integer id){
        UserGateway userGateway = jsonPlaceHolderRepository.getUserById(id).stream().findFirst().orElse(null);
        if(Objects.isNull(userGateway))
            return null;

        List<PostGateway> postGateways = jsonPlaceHolderRepository.getPostByUserId(id);
        List<CommentGateway> commentGateways = jsonPlaceHolderRepository.getComments();
        List<AlbumGateway> albumGateways = jsonPlaceHolderRepository.getAlbumByUserId(id);
        List<PhotoGateway> photoGateways = jsonPlaceHolderRepository.getPhotos();
        List<TodoGateway> todoGateways = jsonPlaceHolderRepository.getTodoByUserId(id);

        List<AlbumResponseGateway> responseAlbum = MapperGateway.mapToAlbumResponseList(albumGateways, photoGateways);

        List<PostResponseGateway> responsePost = MapperGateway.mapToPostResponseList(postGateways, commentGateways);

        return MapperGateway.mapToUserResponse(userGateway, todoGateways, responseAlbum, responsePost);
//        return jsonPlaceHolderRepository.getSpecificUser(id).stream().findFirst().orElse(null);
    }
}

package com.example.demo.service;

import com.example.demo.model.gateway.*;
import com.example.demo.model.gateway.completeuser.CompleteUserAlbumGateway;
import com.example.demo.model.gateway.completeuser.CompleteUserPostGateway;
import com.example.demo.model.gateway.completeuser.CompleteUserGateway;
import com.example.demo.model.gateway.user.UserGateway;
import com.example.demo.repository.unit.GatewayRepository;
import com.example.demo.utils.gateway.MapperGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor

public class GatewayService {

    private final GatewayRepository gatewayRepository;

    public List<UserGateway> getAllUsers(){
        return gatewayRepository.getUsers();
    }

    public List<TodoGateway> getAllTodos(){
        return gatewayRepository.getTodos();
    }

    public List<PostGateway> getAllPosts(){
        return gatewayRepository.getPosts();
    }

    public List<CommentGateway> getAllComments(){
        return gatewayRepository.getComments();
    }

    public List<AlbumGateway> getAllAlbums(){
        return gatewayRepository.getAlbums();
    }

    public List<PhotoGateway> getAllPhotos(){
        return gatewayRepository.getPhotos();
    }

    public List<CompleteUserPostGateway> getCompletePost (){
        List<PostGateway> postGateways = gatewayRepository.getPosts();
        List<CommentGateway> commentGateways = gatewayRepository.getComments();
        List<CompleteUserPostGateway> responsePost = MapperGateway.mapToPostResponseList(postGateways, commentGateways);
        return responsePost;
    }

    public List<CompleteUserAlbumGateway> getCompleteAlbum(){
        List<AlbumGateway> albumGateways = gatewayRepository.getAlbums();
        List<PhotoGateway> photoGateways = gatewayRepository.getPhotos();
        List<CompleteUserAlbumGateway> responseAlbum = MapperGateway.mapToAlbumResponseList(albumGateways, photoGateways);
        return responseAlbum;
    };

    public List<CompleteUserGateway> getCompleteUser(){
        List<UserGateway> userGateways = gatewayRepository.getUsers();
        List<TodoGateway> todoGateways = gatewayRepository.getTodos();
        List<CompleteUserAlbumGateway> albums = getCompleteAlbum();
        List<CompleteUserPostGateway> posts = getCompletePost();
        List<CompleteUserGateway> responseUser = MapperGateway.mapToUserResponseList(userGateways,
                todoGateways, albums, posts);
        return responseUser;
    };

    public CompleteUserGateway getSpecificUser (Integer id){
        UserGateway userGateway = gatewayRepository.getUserById(id).stream().findFirst().orElse(null);
        if(Objects.isNull(userGateway))
            return null;

        List<PostGateway> postGateways = gatewayRepository.getPostByUserId(id);
        List<CommentGateway> commentGateways = gatewayRepository.getComments();
        List<AlbumGateway> albumGateways = gatewayRepository.getAlbumByUserId(id);
        List<PhotoGateway> photoGateways = gatewayRepository.getPhotos();
        List<TodoGateway> todoGateways = gatewayRepository.getTodoByUserId(id);

        List<CompleteUserAlbumGateway> responseAlbum = MapperGateway.mapToAlbumResponseList(albumGateways, photoGateways);

        List<CompleteUserPostGateway> responsePost = MapperGateway.mapToPostResponseList(postGateways, commentGateways);

        return MapperGateway.mapToUserResponse(userGateway, todoGateways, responseAlbum, responsePost);
//        return gatewayRepository.getSpecificUser(id).stream().findFirst().orElse(null);
    }
}

package com.example.demo.utils;

import com.example.demo.model.gateway.*;
import com.example.demo.model.gateway.response.AlbumResponseGateway;
import com.example.demo.model.gateway.response.PostResponseGateway;
import com.example.demo.model.gateway.response.UserResponseGateway;
import com.example.demo.model.gateway.user.UserGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor

public class Mapper {

//        List<CommentGateway> filteredComments = filter.filteredCommentByPostId(commentGateways, post.getId());
//            return converter.convertPost(post, filteredComments);

    public static PostResponseGateway mapToPostResponse (PostGateway postGateway, List<CommentGateway> commentGateways){
        List<CommentGateway> filteredCommentGateways = Filter.filteredCommentByPostId(commentGateways, postGateway.getId());
                return Converter.convertPost(postGateway, filteredCommentGateways);
    }

    public static List<PostResponseGateway> mapToPostResponseList (List<PostGateway> postGateways, List<CommentGateway> commentGateways){
        return postGateways.stream()
                .map(post -> mapToPostResponse(post, commentGateways))
                .collect(Collectors.toList());
    }

//    List<PhotoGateway> filteredPhotos = filter.filteredPhotoByAlbumId(photoGateways, album.getId());
//            return converter.convertAlbum(album, filteredPhotos);

    public static AlbumResponseGateway mapToAlbumResponse (AlbumGateway albumGateway, List<PhotoGateway> photoGateways){
        List<PhotoGateway> filteredPhotoGateways = Filter.filteredPhotoByAlbumId(photoGateways, albumGateway.getId());
        return Converter.convertAlbum(albumGateway, filteredPhotoGateways);
    }

    public static List<AlbumResponseGateway> mapToAlbumResponseList (List<AlbumGateway> albumGateways, List<PhotoGateway> photoGateways){
        return albumGateways.stream()
                .map(albumGateway -> mapToAlbumResponse(albumGateway, photoGateways))
                .collect(Collectors.toList());
    }

//        List<TodoGateway> filteredTodo = Filter.filteredTodoByUserId(todoGateways, user.getId());
//        List<AlbumResponseGateway> filteredAlbum = Filter.filteredAlbumByUserId(albums, user.getId());
//        List<PostResponseGateway> filteredPost = Filter.filteredPostByUserId(posts, user.getId());
//
//        return Converter.convertUser(user, filteredAlbum, filteredPost, filteredTodo);

    public static UserResponseGateway mapToUserResponse (UserGateway userGateway, List<TodoGateway> todoGateways,
                                                         List<AlbumResponseGateway> albums, List<PostResponseGateway> posts){

        List<TodoGateway> filteredTodoGateway = Filter.filteredTodoByUserId(todoGateways, userGateway.getId());
        List<AlbumResponseGateway> filteredAlbum = Filter.filteredAlbumByUserId(albums, userGateway.getId());
        List<PostResponseGateway> filteredPost = Filter.filteredPostByUserId(posts, userGateway.getId());

        return Converter.convertUser(userGateway, filteredAlbum, filteredPost, filteredTodoGateway);
    }

    public static List<UserResponseGateway> mapToUserResponseList (List<UserGateway> userGateways, List<TodoGateway> todoGateways,
                                                                   List<AlbumResponseGateway> albums, List<PostResponseGateway> posts){
        return userGateways.stream()
                .map(user -> mapToUserResponse(user, todoGateways, albums, posts))
                .collect(Collectors.toList());
    }
}

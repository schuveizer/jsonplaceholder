package com.example.demo.utils.gateway;

import com.example.demo.model.gateway.*;
import com.example.demo.model.gateway.response.AlbumResponseGateway;
import com.example.demo.model.gateway.response.PostResponseGateway;
import com.example.demo.model.gateway.response.UserResponseGateway;
import com.example.demo.model.gateway.user.UserGateway;
import com.example.demo.utils.gateway.ConverterGateway;
import com.example.demo.utils.gateway.FilterGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor

public class MapperGateway {

//        List<CommentGateway> filteredComments = filter.filteredCommentByPostId(commentGateways, post.getId());
//            return converter.convertPost(post, filteredComments);

    public static PostResponseGateway mapToPostResponse (PostGateway postGateway, List<CommentGateway> commentGateways){
        List<CommentGateway> filteredCommentGateways = FilterGateway.filteredCommentByPostId(commentGateways, postGateway.getId());
                return ConverterGateway.convertPost(postGateway, filteredCommentGateways);
    }

    public static List<PostResponseGateway> mapToPostResponseList (List<PostGateway> postGateways, List<CommentGateway> commentGateways){
        return postGateways.stream()
                .map(post -> mapToPostResponse(post, commentGateways))
                .collect(Collectors.toList());
    }

//    List<PhotoGateway> filteredPhotos = filter.filteredPhotoByAlbumId(photoGateways, album.getId());
//            return converter.convertAlbum(album, filteredPhotos);

    public static AlbumResponseGateway mapToAlbumResponse (AlbumGateway albumGateway, List<PhotoGateway> photoGateways){
        List<PhotoGateway> filteredPhotoGateways = FilterGateway.filteredPhotoByAlbumId(photoGateways, albumGateway.getId());
        return ConverterGateway.convertAlbum(albumGateway, filteredPhotoGateways);
    }

    public static List<AlbumResponseGateway> mapToAlbumResponseList (List<AlbumGateway> albumGateways, List<PhotoGateway> photoGateways){
        return albumGateways.stream()
                .map(albumGateway -> mapToAlbumResponse(albumGateway, photoGateways))
                .collect(Collectors.toList());
    }

//        List<TodoGateway> filteredTodo = FilterGateway.filteredTodoByUserId(todoGateways, user.getId());
//        List<AlbumResponseGateway> filteredAlbum = FilterGateway.filteredAlbumByUserId(albums, user.getId());
//        List<PostResponseGateway> filteredPost = FilterGateway.filteredPostByUserId(posts, user.getId());
//
//        return ConverterGateway.convertUser(user, filteredAlbum, filteredPost, filteredTodo);

    public static UserResponseGateway mapToUserResponse (UserGateway userGateway, List<TodoGateway> todoGateways,
                                                         List<AlbumResponseGateway> albums, List<PostResponseGateway> posts){

        List<TodoGateway> filteredTodoGateway = FilterGateway.filteredTodoByUserId(todoGateways, userGateway.getId());
        List<AlbumResponseGateway> filteredAlbum = FilterGateway.filteredAlbumByUserId(albums, userGateway.getId());
        List<PostResponseGateway> filteredPost = FilterGateway.filteredPostByUserId(posts, userGateway.getId());

        return ConverterGateway.convertUser(userGateway, filteredAlbum, filteredPost, filteredTodoGateway);
    }

    public static List<UserResponseGateway> mapToUserResponseList (List<UserGateway> userGateways, List<TodoGateway> todoGateways,
                                                                   List<AlbumResponseGateway> albums, List<PostResponseGateway> posts){
        return userGateways.stream()
                .map(user -> mapToUserResponse(user, todoGateways, albums, posts))
                .collect(Collectors.toList());
    }
}

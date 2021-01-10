package com.example.demo.utils.gateway;

import com.example.demo.model.gateway.*;
import com.example.demo.model.gateway.response.AlbumResponseGateway;
import com.example.demo.model.gateway.response.PostResponseGateway;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component

public class FilterGateway {

//    List<TodoGateway> filteredTodo = todoGateways.stream()
//            .filter(todo -> todo.getUserId().equals(user.getId()))
//            .collect(Collectors.toList());

    public static List<TodoGateway> filteredTodoByUserId (List<TodoGateway> todoGateways, Integer userId){
        return   todoGateways.stream()
                .filter(todo -> todo.getUserId().equals(userId))
                .collect(Collectors.toList());
    }

//    List<AlbumResponseGateway> filteredAlbum = albums.stream()
//            .filter(albumResponse -> albumResponse.getUserId().equals(user.getId()))
//            .collect(Collectors.toList());

    public static List<AlbumResponseGateway> filteredAlbumByUserId (List<AlbumResponseGateway> albums, Integer userId){
        return albums.stream()
                .filter(albumResponse -> albumResponse.getUserId().equals(userId))
                .collect(Collectors.toList());
    }

//    List<PostResponseGateway> filteredPost = posts.stream()
//            .filter(postResponse -> postResponse.getUserId().equals(user.getId()))
//            .collect(Collectors.toList());

    public static List<PostResponseGateway> filteredPostByUserId (List<PostResponseGateway> posts, Integer userId){
        return posts.stream()
                .filter(postResponse -> postResponse.getUserId().equals(userId))
                .collect(Collectors.toList());
    }

//    List<PhotoGateway> filteredPhotos = photoGateways.stream()
//            .filter(photo -> photo.getAlbumId().equals(album.getId()))
//            .collect(Collectors.toList());

    public static List<PhotoGateway> filteredPhotoByAlbumId (List<PhotoGateway> photoGateways, Integer albumId){
        return photoGateways.stream()
                .filter(photo -> photo.getAlbumId().equals(albumId))
                .collect(Collectors.toList());
    }

//    List<CommentGateway> filteredComments = commentGateways.stream()
//            .filter(comment -> comment.getPostId().equals(post.getId()))
//            .collect(Collectors.toList());

    public static List<CommentGateway> filteredCommentByPostId (List<CommentGateway> commentGateways, Integer postId){
        return commentGateways.stream()
                .filter(comment -> comment.getPostId().equals(postId))
                .collect(Collectors.toList());
    }
}

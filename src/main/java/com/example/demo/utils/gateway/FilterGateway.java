package com.example.demo.utils.gateway;

import com.example.demo.model.gateway.*;
import com.example.demo.model.gateway.completeuser.CompleteUserAlbumGateway;
import com.example.demo.model.gateway.completeuser.CompleteUserPostGateway;
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

//    List<CompleteUserAlbumGateway> filteredAlbum = albums.stream()
//            .filter(albumResponse -> albumResponse.getUserId().equals(user.getId()))
//            .collect(Collectors.toList());

    public static List<CompleteUserAlbumGateway> filteredAlbumByUserId (List<CompleteUserAlbumGateway> albums, Integer userId){
        return albums.stream()
                .filter(albumResponse -> albumResponse.getUserId().equals(userId))
                .collect(Collectors.toList());
    }

//    List<CompleteUserPostGateway> filteredPost = posts.stream()
//            .filter(postResponse -> postResponse.getUserId().equals(user.getId()))
//            .collect(Collectors.toList());

    public static List<CompleteUserPostGateway> filteredPostByUserId (List<CompleteUserPostGateway> posts, Integer userId){
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

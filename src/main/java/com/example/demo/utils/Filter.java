package com.example.demo.utils;

import com.example.demo.model.jsonplaceholder.*;
import com.example.demo.model.jsonplaceholder.response.AlbumResponse;
import com.example.demo.model.jsonplaceholder.response.PostResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component

public class Filter {

//    List<Todo> filteredTodo = todos.stream()
//            .filter(todo -> todo.getUserId().equals(user.getId()))
//            .collect(Collectors.toList());

    public static List<Todo> filteredTodoByUserId (List<Todo> todos, Integer userId){
        return   todos.stream()
                .filter(todo -> todo.getUserId().equals(userId))
                .collect(Collectors.toList());
    }

//    List<AlbumResponse> filteredAlbum = albums.stream()
//            .filter(albumResponse -> albumResponse.getUserId().equals(user.getId()))
//            .collect(Collectors.toList());

    public static List<AlbumResponse> filteredAlbumByUserId (List<AlbumResponse> albums, Integer userId){
        return albums.stream()
                .filter(albumResponse -> albumResponse.getUserId().equals(userId))
                .collect(Collectors.toList());
    }

//    List<PostResponse> filteredPost = posts.stream()
//            .filter(postResponse -> postResponse.getUserId().equals(user.getId()))
//            .collect(Collectors.toList());

    public static List<PostResponse> filteredPostByUserId (List<PostResponse> posts, Integer userId){
        return posts.stream()
                .filter(postResponse -> postResponse.getUserId().equals(userId))
                .collect(Collectors.toList());
    }

//    List<Photo> filteredPhotos = photos.stream()
//            .filter(photo -> photo.getAlbumId().equals(album.getId()))
//            .collect(Collectors.toList());

    public static List<Photo> filteredPhotoByAlbumId (List<Photo> photos, Integer albumId){
        return photos.stream()
                .filter(photo -> photo.getAlbumId().equals(albumId))
                .collect(Collectors.toList());
    }

//    List<Comment> filteredComments = comments.stream()
//            .filter(comment -> comment.getPostId().equals(post.getId()))
//            .collect(Collectors.toList());

    public static List<Comment> filteredCommentByPostId (List<Comment> comments, Integer postId){
        return comments.stream()
                .filter(comment -> comment.getPostId().equals(postId))
                .collect(Collectors.toList());
    }
}

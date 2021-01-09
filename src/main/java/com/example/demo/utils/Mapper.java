package com.example.demo.utils;

import com.example.demo.model.jsonplaceholder.*;
import com.example.demo.model.jsonplaceholder.response.AlbumResponse;
import com.example.demo.model.jsonplaceholder.response.PostResponse;
import com.example.demo.model.jsonplaceholder.response.UserResponse;
import com.example.demo.model.jsonplaceholder.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor

public class Mapper {

//        List<Comment> filteredComments = filter.filteredCommentByPostId(comments, post.getId());
//            return converter.convertPost(post, filteredComments);

    public static PostResponse mapToPostResponse (Post post, List<Comment> comments){
        List<Comment> filteredComments = Filter.filteredCommentByPostId(comments, post.getId());
                return Converter.convertPost(post, filteredComments);
    }

    public static List<PostResponse> mapToPostResponseList (List<Post> posts, List<Comment> comments){
        return posts.stream()
                .map(post -> mapToPostResponse(post, comments))
                .collect(Collectors.toList());
    }

//    List<Photo> filteredPhotos = filter.filteredPhotoByAlbumId(photos, album.getId());
//            return converter.convertAlbum(album, filteredPhotos);

    public static AlbumResponse mapToAlbumResponse (Album album, List<Photo> photos){
        List<Photo> filteredPhotos = Filter.filteredPhotoByAlbumId(photos, album.getId());
        return Converter.convertAlbum(album, filteredPhotos);
    }

    public static List<AlbumResponse> mapToAlbumResponseList (List<Album> albums, List<Photo> photos){
        return albums.stream()
                .map(album -> mapToAlbumResponse(album, photos))
                .collect(Collectors.toList());
    }

//        List<Todo> filteredTodo = Filter.filteredTodoByUserId(todos, user.getId());
//        List<AlbumResponse> filteredAlbum = Filter.filteredAlbumByUserId(albums, user.getId());
//        List<PostResponse> filteredPost = Filter.filteredPostByUserId(posts, user.getId());
//
//        return Converter.convertUser(user, filteredAlbum, filteredPost, filteredTodo);

    public static UserResponse mapToUserResponse (User user, List<Todo> todos,
                                                  List<AlbumResponse> albums, List<PostResponse> posts){

        List<Todo> filteredTodo = Filter.filteredTodoByUserId(todos, user.getId());
        List<AlbumResponse> filteredAlbum = Filter.filteredAlbumByUserId(albums, user.getId());
        List<PostResponse> filteredPost = Filter.filteredPostByUserId(posts, user.getId());

        return Converter.convertUser(user, filteredAlbum, filteredPost, filteredTodo);
    }

    public static List<UserResponse> mapToUserResponseList (List<User> users, List<Todo> todos,
                                                            List<AlbumResponse> albums, List<PostResponse> posts){
        return users.stream()
                .map(user -> mapToUserResponse(user, todos, albums, posts))
                .collect(Collectors.toList());
    }
}

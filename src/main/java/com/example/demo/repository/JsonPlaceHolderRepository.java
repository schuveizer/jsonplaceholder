// Camada de acesso a outros sistemas (Banco de Dados e API's externas)

package com.example.demo.repository;

import com.example.demo.model.jsonplaceholder.*;
import com.example.demo.model.jsonplaceholder.response.UserResponse;
import com.example.demo.model.jsonplaceholder.user.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.websocket.server.PathParam;
import java.util.List;

@FeignClient (url = "https://jsonplaceholder.typicode.com", name = "number")
@Component

public interface JsonPlaceHolderRepository {
    @GetMapping ("/todos/{id}")
    Todo getTestRepository (@PathVariable Integer id);

    @GetMapping ("/posts")
    List<Post> getPosts();

    @GetMapping ("/comments")
    List<Comment> getComments();

    @GetMapping ("/albums")
    List<Album> getAlbums();

    @GetMapping ("/photos")
    List<Photo> getPhotos();

    @GetMapping ("/users")
    List<User> getUsers();

    @GetMapping ("/todos")
    List<Todo> getTodos();

    @GetMapping ("/posts")
    List<Post> getPostByUserId (@RequestParam Integer userId);
//    (value = "userId")

//    @GetMapping ("/comments")
//    List<Comment> getCommentByPostId (@RequestParam Integer postId);

    @GetMapping ("/albums")
    List<Album> getAlbumByUserId (@RequestParam Integer userId);

//    @GetMapping ("/photo")
//    List<Photo> getPhotoByAlbumId (@RequestParam Integer albumId);

    @GetMapping ("/todos")
    List<Todo> getTodoByUserId (@RequestParam Integer userId);

    @GetMapping ("/users")
    List<User> getUserById (@RequestParam Integer id);

}

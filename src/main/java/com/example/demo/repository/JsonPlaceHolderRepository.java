// Camada de acesso a outros sistemas (Banco de Dados e API's externas)

package com.example.demo.repository;

import com.example.demo.model.gateway.*;
import com.example.demo.model.gateway.user.UserGateway;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient (url = "https://jsonplaceholder.typicode.com", name = "number")
@Component

public interface JsonPlaceHolderRepository {
    @GetMapping ("/todos/{id}")
    TodoGateway getTestRepository (@PathVariable Integer id);

    @GetMapping ("/posts")
    List<PostGateway> getPosts();

    @GetMapping ("/comments")
    List<CommentGateway> getComments();

    @GetMapping ("/albums")
    List<AlbumGateway> getAlbums();

    @GetMapping ("/photos")
    List<PhotoGateway> getPhotos();

    @GetMapping ("/users")
    List<UserGateway> getUsers();

    @GetMapping ("/todos")
    List<TodoGateway> getTodos();

    @GetMapping ("/posts")
    List<PostGateway> getPostByUserId (@RequestParam Integer userId);
//    (value = "userId")

//    @GetMapping ("/commentGateways")
//    List<CommentGateway> getCommentByPostId (@RequestParam Integer postId);

    @GetMapping ("/albums")
    List<AlbumGateway> getAlbumByUserId (@RequestParam Integer userId);

//    @GetMapping ("/photo")
//    List<PhotoGateway> getPhotoByAlbumId (@RequestParam Integer albumId);

    @GetMapping ("/todos")
    List<TodoGateway> getTodoByUserId (@RequestParam Integer userId);

    @GetMapping ("/users")
    List<UserGateway> getUserById (@RequestParam Integer id);

}

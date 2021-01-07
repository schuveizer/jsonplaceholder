// Camada de acesso a outros sistemas (Banco de Dados e API's externas)

package com.example.demo.repository;

import com.example.demo.model.jsonplaceholder.*;
import com.example.demo.model.jsonplaceholder.user.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

}

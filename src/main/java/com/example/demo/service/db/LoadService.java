package com.example.demo.service.db;

import com.example.demo.model.domain.unit.*;
import com.example.demo.model.domain.unit.user.UserDomain;
import com.example.demo.model.gateway.*;
import com.example.demo.model.gateway.user.UserGateway;
import com.example.demo.service.GatewayService;
import com.example.demo.service.db.unit.*;
import com.example.demo.utils.db.unit.*;
import com.example.demo.utils.sort.AlbumSort;
import com.example.demo.utils.sort.PostSort;
import com.example.demo.utils.sort.UserSort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class LoadService {

    private final AlbumService albumService;
    private final CommentService commentService;
    private final PhotoService photoService;
    private final PostService postService;
    private final TodoService todoService;
    private final UserService userService;
    private final GatewayService gatewayService;

    public void purgeDB(){
        photoService.purgeDB();
        albumService.purgeDB();
        commentService.purgeDB();
        postService.purgeDB();
        todoService.purgeDB();
        userService.purgeDB();

    }

    public void fullLoad() {
        purgeDB();
        System.out.println("Getting Gateway Info");
        List<UserGateway> users = gatewayService.getAllUsers();
        List<AlbumGateway> albums = gatewayService.getAllAlbums();
        List<PhotoGateway> photos = gatewayService.getAllPhotos();
        List<PostGateway> posts = gatewayService.getAllPosts();
        List<CommentGateway> comments = gatewayService.getAllComments();
        List<TodoGateway> todos = gatewayService.getAllTodos();

        List<UserDomain> convertedUsers = users.stream()
                .map(ConverterUserDB::convertUserGatewayToDomain)
                .collect(Collectors.toList());

        List<AlbumDomain> convertedAlbums = new ArrayList<>();
        List<PhotoDomain> convertedPhotos = new ArrayList<>();
        List<PostDomain> convertedPosts = new ArrayList<>();
        List<CommentDomain> convertedComments = new ArrayList<>();
        List<TodoDomain> convertedTodos = new ArrayList<>();
        System.out.println("Inserting Users");
        convertedUsers = userService.fullLoad(convertedUsers);
        convertedUsers = UserSort.sortDomain(convertedUsers);
        users = UserSort.sortGateway(users);
        System.out.println("Mapping UserIds");
        for (int i = 0; i < users.size(); i++) {
            UserGateway currentUserGateway = users.get(i);
            UserDomain currentUserDomain = convertedUsers.get(i);
            albums.stream().filter(album -> album.getUserId().equals(currentUserGateway.getId()))
                    .forEach(album -> convertedAlbums
                            .add(ConverterAlbumDB.convertAlbumGatewayToDomainWithUserId(album, currentUserDomain.getId())));
            posts.stream().filter(post -> post.getUserId().equals(currentUserGateway.getId()))
                    .forEach(post -> convertedPosts
                            .add(ConverterPostDB.convertPostGatewayToDomainWithUserId(post, currentUserDomain.getId())));
            todos.stream().filter(todo -> todo.getUserId().equals(currentUserGateway.getId()))
                    .forEach(todo -> convertedTodos
                            .add(ConverterTodoDB.convertTodoGatewayToDomainWithUserId(todo, currentUserDomain.getId())));
        }
        System.out.println("Inserting Todos");
        todoService.fullLoad(convertedTodos);

        System.out.println("Inserting Albums");
        List<AlbumDomain> convertedAlbumsWithId = albumService.fullLoad(convertedAlbums);

        convertedAlbumsWithId = AlbumSort.sortDomain(convertedAlbumsWithId);
        albums = AlbumSort.sortGateway(albums);
        System.out.println("Mapping AlbumIds");
        for (int i = 0; i < albums.size(); i++) {
            AlbumGateway currentAlbumGateway = albums.get(i);
            AlbumDomain currentAlbumDomain = convertedAlbumsWithId.get(i);
            photos.stream().filter(photo -> photo.getAlbumId().equals(currentAlbumGateway.getId()))
                    .forEach(photo -> convertedPhotos
                            .add(ConverterPhotoDB.convertPhotoGatewayToDomainWithAlbumId(photo, currentAlbumDomain.getId())));
        }
        System.out.println("Inserting Photos");
        photoService.fullLoad(convertedPhotos);

        System.out.println("Inserting Posts");
        List<PostDomain> convertedPostsWithId = postService.fullLoad(convertedPosts);

        convertedPostsWithId = PostSort.sortDomain(convertedPostsWithId);
        posts = PostSort.sortGateway(posts);
        System.out.println("Mapping PostIds");
        for (int i = 0; i < albums.size(); i++) {
            PostGateway currentPostGateway = posts.get(i);
            PostDomain currentPostDomain = convertedPostsWithId.get(i);
            comments.stream().filter(comment -> comment.getPostId().equals(currentPostGateway.getId()))
                    .forEach(comment -> convertedComments
                            .add(ConverterCommentDB.convertCommentGatewayToDomainWithPostId(comment, currentPostDomain.getId())));
        }
        System.out.println("Inserting Comments");
        commentService.fullLoad(convertedComments);
        System.out.println("Conclude");
    }

    public void strictFullLoad(){
        purgeDB();
        List<UserGateway> users = gatewayService.getAllUsers();
        List<AlbumGateway> albums = gatewayService.getAllAlbums();
        List<PhotoGateway> photos = gatewayService.getAllPhotos();
        List<PostGateway> posts = gatewayService.getAllPosts();
        List<CommentGateway> comments = gatewayService.getAllComments();
        List<TodoGateway> todos = gatewayService.getAllTodos();

        users.forEach(user -> {
            System.out.println("AAAAAAAAAAAAAAA");
            UserDomain convertedUser = ConverterUserDB.convertUserGatewayToDomain(user);
            convertedUser = userService.strictCreate(convertedUser);
            String userId = convertedUser.getId();

            List<TodoDomain> convertedTodos = todos.stream()
                    .filter(todo -> todo.getUserId().equals(user.getId()))
                    .map(todo -> ConverterTodoDB.convertTodoGatewayToDomainWithUserId(todo, userId))
                    .collect(Collectors.toList());
            todoService.fullLoad(convertedTodos);

            List<AlbumGateway> filteredAlbums = albums.stream()
                    .filter(album -> album.getUserId().equals(user.getId()))
                    .collect(Collectors.toList());
            filteredAlbums.forEach(album -> {
                System.out.println("AAAAAAAAAAAAAAA2");
                AlbumDomain convertedAlbum = ConverterAlbumDB.convertAlbumGatewayToDomainWithUserId(album, userId);
                convertedAlbum = albumService.strictCreate(convertedAlbum);

                String albumId = convertedAlbum.getId();

                List<PhotoDomain> convertedPhotos = photos.stream()
                        .filter(photo -> photo.getAlbumId().equals(album.getId()))
                        .map(photo -> ConverterPhotoDB.convertPhotoGatewayToDomainWithAlbumId(photo, albumId))
                        .collect(Collectors.toList());
                photoService.fullLoad(convertedPhotos);
            });

            List<PostGateway> filteredPosts = posts.stream()
                    .filter(post -> post.getUserId().equals(user.getId()))
                    .collect(Collectors.toList());
            filteredPosts.forEach(post -> {
                System.out.println("AAAAAAAAAAAAAAA3");
                PostDomain convertPost = ConverterPostDB.convertPostGatewayToDomainWithUserId(post, userId);
                convertPost = postService.strictCreate(convertPost);

                String postId = convertPost.getId();

                List<CommentDomain> convertedComments = comments.stream()
                        .filter(comment -> comment.getPostId().equals(post.getId()))
                        .map(comment -> ConverterCommentDB.convertCommentGatewayToDomainWithPostId(comment, postId))
                        .collect(Collectors.toList());
                commentService.fullLoad(convertedComments);
            });
        });
    }
}

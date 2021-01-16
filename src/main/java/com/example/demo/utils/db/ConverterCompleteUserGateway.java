package com.example.demo.utils.db;

import com.example.demo.model.domain.completeuser.*;
import com.example.demo.model.gateway.CommentGateway;
import com.example.demo.model.gateway.PhotoGateway;
import com.example.demo.model.gateway.TodoGateway;
import com.example.demo.model.gateway.completeuser.CompleteUserAlbumGateway;
import com.example.demo.model.gateway.completeuser.CompleteUserGateway;
import com.example.demo.model.gateway.completeuser.CompleteUserPostGateway;
import com.example.demo.utils.db.unit.ConverterUserDB;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;


@Component
@RequiredArgsConstructor

public class ConverterCompleteUserGateway {

    public static CompleteUserDomain convertCompleteUserGatewayToDomain (CompleteUserGateway user){
        return CompleteUserDomain.builder()
                .name(user.getName())
                .username(user.getUsername())
                .email(user.getEmail())
                .address(ConverterUserDB.convertUserAddressGatewayToDomain(user.getAddress()))
                .phone(user.getPhone())
                .website(user.getWebsite())
                .company(ConverterUserDB.convertUserCompanyGatewayToDomain(user.getCompany()))
                .posts(user.getPosts().stream()
                        .map(ConverterCompleteUserGateway::convertCompleteUserPostGatewayToDomain)
                        .collect(Collectors.toList()))
                .albums(user.getAlbums().stream()
                        .map(ConverterCompleteUserGateway::convertCompleteUserAlbumGatewayToDomain)
                        .collect(Collectors.toList()))
                .todos(user.getTodos().stream()
                        .map(ConverterCompleteUserGateway::convertCompleteUserTodoGatewayToDomain)
                        .collect(Collectors.toList()))
                .build();
    }


    private static CompleteUserPostDomain convertCompleteUserPostGatewayToDomain(CompleteUserPostGateway post) {
        return CompleteUserPostDomain.builder()
                .title(post.getTitle())
                .body(post.getBody())
                .comments(post.getComments().stream()
                        .map(ConverterCompleteUserGateway::convertCompleteUserCommentGatewayToDomain)
                        .collect(Collectors.toList()))
                .build();
    }

    private static CompleteUserCommentDomain convertCompleteUserCommentGatewayToDomain(CommentGateway comment) {
        return CompleteUserCommentDomain.builder()
                .name(comment.getName())
                .email(comment.getEmail())
                .body(comment.getBody())
                .build();
    }

    private static CompleteUserAlbumDomain convertCompleteUserAlbumGatewayToDomain(CompleteUserAlbumGateway album) {
        return CompleteUserAlbumDomain.builder()
                .title(album.getTitle())
                .photos(album.getPhotos().stream()
                        .map(ConverterCompleteUserGateway::convertCompleteUserPhotoGatewayToDomain)
                        .collect(Collectors.toList()))
                .build();
    }

    private static CompleteUserPhotoDomain convertCompleteUserPhotoGatewayToDomain(PhotoGateway photo) {
        return CompleteUserPhotoDomain.builder()
                .title(photo.getTitle())
                .url(photo.getUrl())
                .thumbnailUrl(photo.getThumbnailUrl())
                .build();
    }

    private static CompleteUserTodoDomain convertCompleteUserTodoGatewayToDomain(TodoGateway todo) {
        return CompleteUserTodoDomain.builder()
                .title(todo.getTitle())
                .completed(todo.getCompleted())
                .build();
    }

}

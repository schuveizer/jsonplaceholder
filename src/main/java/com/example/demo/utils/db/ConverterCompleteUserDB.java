package com.example.demo.utils.db;

import com.example.demo.model.domain.completeuser.*;
import com.example.demo.model.domain.unit.user.UserAddressDomain;
import com.example.demo.model.domain.unit.user.UserAddressGeoDomain;
import com.example.demo.model.domain.unit.user.UserCompanyDomain;
import com.example.demo.model.dto.completeuser.*;
import com.example.demo.model.dto.unit.user.UserAddressDTO;
import com.example.demo.model.dto.unit.user.UserAddressGeoDTO;
import com.example.demo.model.dto.unit.user.UserCompanyDTO;
import com.example.demo.model.request.CompleteUserRequest;
import com.example.demo.model.response.CompleteUserResponse;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component

public class ConverterCompleteUserDB {

    public static CompleteUserDomain convertCompleteUserRequestToDomain(CompleteUserRequest user) {
        return CompleteUserDomain.builder()
                .name(user.getName())
                .username(user.getUsername())
                .email(user.getEmail())
                .address(convertUserAddressDTOToDomain(user.getAddress()))
                .phone(user.getPhone())
                .website(user.getWebsite())
                .company(convertUserCompanyDTOToDomain(user.getCompany()))
                .posts(user.getPosts().stream()
                        .map(ConverterCompleteUserDB::convertCompleteUserPostDTOToDomain)
                        .collect(Collectors.toList()))
                .albums(user.getAlbums().stream()
                        .map(ConverterCompleteUserDB::convertCompleteUserAlbumDTOToDomain)
                        .collect(Collectors.toList()))
                .todos(user.getTodos().stream()
                        .map(ConverterCompleteUserDB::convertCompleteUserTodoDTOToDomain)
                        .collect(Collectors.toList()))
                .build();
    }

    private static UserAddressDomain convertUserAddressDTOToDomain(UserAddressDTO address) {
        return UserAddressDomain.builder()
                .street(address.getStreet())
                .suite(address.getSuite())
                .city(address.getCity())
                .zipcode(address.getZipcode())
                .geo(UserAddressGeoDomain.builder()
                        .lat(address.getGeo().getLat())
                        .lng(address.getGeo().getLng())
                        .build())
                .build();
    }

    private static UserCompanyDomain convertUserCompanyDTOToDomain(UserCompanyDTO company) {
        return UserCompanyDomain.builder()
                .name(company.getName())
                .catchPhrase(company.getCatchPhrase())
                .bs(company.getBs())
                .build();
    }

    private static CompleteUserPostDomain convertCompleteUserPostDTOToDomain(CompleteUserPostDTO post) {
        return CompleteUserPostDomain.builder()
                .title(post.getTitle())
                .body(post.getBody())
                .comments(post.getComments().stream()
                        .map(ConverterCompleteUserDB::convertCompleteUserCommentDTOToDomain)
                        .collect(Collectors.toList()))
                .build();
    }

    private static CompleteUserCommentDomain convertCompleteUserCommentDTOToDomain(CompleteUserCommentDTO comment) {
        return CompleteUserCommentDomain.builder()
                .name(comment.getName())
                .email(comment.getEmail())
                .body(comment.getBody())
                .build();
    }

    private static CompleteUserAlbumDomain convertCompleteUserAlbumDTOToDomain(CompleteUserAlbumDTO album) {
        return CompleteUserAlbumDomain.builder()
                .title(album.getTitle())
                .photos(album.getPhotos().stream()
                        .map(ConverterCompleteUserDB::convertCompleteUserPhotoDTOToDomain)
                        .collect(Collectors.toList()))
                .build();
    }

    private static CompleteUserPhotoDomain convertCompleteUserPhotoDTOToDomain(CompleteUserPhotoDTO photo) {
        return CompleteUserPhotoDomain.builder()
                .title(photo.getTitle())
                .url(photo.getUrl())
                .thumbnailUrl(photo.getThumbnailUrl())
                .build();
    }

    private static CompleteUserTodoDomain convertCompleteUserTodoDTOToDomain(CompleteUserTodoDTO todo) {
        return CompleteUserTodoDomain.builder()
                .title(todo.getTitle())
                .completed(todo.getCompleted())
                .build();
    }

    public static CompleteUserResponse convertCompleteUserDomainToResponse(CompleteUserDomain user) {
        return CompleteUserResponse.builder()
                .id(user.getId().toHexString())
                .name(user.getName())
                .username(user.getUsername())
                .email(user.getEmail())
                .address(convertUserAddressDomainToDTO(user.getAddress()))
                .phone(user.getPhone())
                .website(user.getWebsite())
                .company(convertUserCompanyDomainToDTO(user.getCompany()))
                .posts(user.getPosts().stream()
                        .map(ConverterCompleteUserDB::convertCompleteUserPostDomainToDTO)
                        .collect(Collectors.toList()))
                .albums(user.getAlbums().stream()
                        .map(ConverterCompleteUserDB::convertCompleteUserAlbumDomainToDTO)
                        .collect(Collectors.toList()))
                .todos(user.getTodos().stream()
                        .map(ConverterCompleteUserDB::convertCompleteUserTodoDTOToDomain)
                        .collect(Collectors.toList()))
                .build();
    }

    private static UserAddressDTO convertUserAddressDomainToDTO(UserAddressDomain address) {
        return UserAddressDTO.builder()
                .street(address.getStreet())
                .suite(address.getSuite())
                .city(address.getCity())
                .zipcode(address.getZipcode())
                .geo(UserAddressGeoDTO.builder()
                        .lat(address.getGeo().getLat())
                        .lng(address.getGeo().getLng())
                        .build())
                .build();
    }

    private static UserCompanyDTO convertUserCompanyDomainToDTO(UserCompanyDomain company) {
        return UserCompanyDTO.builder()
                .name(company.getName())
                .catchPhrase(company.getCatchPhrase())
                .bs(company.getBs())
                .build();
    }

    private static CompleteUserPostDTO convertCompleteUserPostDomainToDTO(CompleteUserPostDomain post) {
        return CompleteUserPostDTO.builder()
                .title(post.getTitle())
                .body(post.getBody())
                .comments(post.getComments().stream()
                        .map(ConverterCompleteUserDB::convertCompleteUserCommentDomainToDTO)
                        .collect(Collectors.toList()))
                .build();
    }

    private static CompleteUserCommentDTO convertCompleteUserCommentDomainToDTO(CompleteUserCommentDomain comment) {
        return CompleteUserCommentDTO.builder()
                .name(comment.getName())
                .email(comment.getEmail())
                .body(comment.getBody())
                .build();
    }

    private static CompleteUserAlbumDTO convertCompleteUserAlbumDomainToDTO(CompleteUserAlbumDomain album) {
        return CompleteUserAlbumDTO.builder()
                .title(album.getTitle())
                .photos(album.getPhotos().stream()
                        .map(ConverterCompleteUserDB::convertCompleteUserPhotoDomainToDTO)
                        .collect(Collectors.toList()))
                .build();
    }

    private static CompleteUserPhotoDTO convertCompleteUserPhotoDomainToDTO(CompleteUserPhotoDomain photo) {
        return CompleteUserPhotoDTO.builder()
                .title(photo.getTitle())
                .url(photo.getUrl())
                .thumbnailUrl(photo.getThumbnailUrl())
                .build();
    }

    private static CompleteUserTodoDTO convertCompleteUserTodoDTOToDomain(CompleteUserTodoDomain todo) {
        return CompleteUserTodoDTO.builder()
                .title(todo.getTitle())
                .completed(todo.getCompleted())
                .build();
    }


}
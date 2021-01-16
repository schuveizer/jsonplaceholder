package com.example.demo.utils.db.unit;

import com.example.demo.model.domain.completeuser.CompleteUserPostDomain;
import com.example.demo.model.domain.unit.PostDomain;
import com.example.demo.model.gateway.PostGateway;
import com.example.demo.model.gateway.completeuser.CompleteUserPostGateway;
import com.example.demo.model.request.unit.PostRequest;
import com.example.demo.model.response.unit.PostResponse;
import com.example.demo.utils.db.ConverterCompleteUserGateway;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component

public class ConverterPostDB {

    public static PostDomain convertPostRequestToDomain (PostRequest post){
        return PostDomain.builder()
                .userId(post.getUserId())
                .title(post.getTitle())
                .body(post.getBody())
                .build();
    }

    public static PostResponse convertPostDomainToResponse (PostDomain post){
        return PostResponse.builder()
                .userId(post.getUserId())
                .id(post.getId())
                .title(post.getTitle())
                .body(post.getBody())
                .build();
    }

    public static PostDomain convertPostGatewayToDomain(PostGateway post) {
        return PostDomain.builder()
                .title(post.getTitle())
                .body(post.getBody())
                .build();
    }

    public static PostDomain convertPostGatewayToDomainWithUserId (PostGateway post, String userId) {
        return PostDomain.builder()
                .userId(userId)
                .title(post.getTitle())
                .body(post.getBody())
                .build();
    }

}

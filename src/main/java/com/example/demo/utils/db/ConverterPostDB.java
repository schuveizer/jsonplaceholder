package com.example.demo.utils.db;

import com.example.demo.model.domain.PostDomain;
import com.example.demo.model.request.PostRequest;
import com.example.demo.model.response.PostResponse;
import org.springframework.stereotype.Component;

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
}

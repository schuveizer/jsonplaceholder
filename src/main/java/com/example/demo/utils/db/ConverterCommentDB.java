package com.example.demo.utils.db;

import com.example.demo.model.domain.CommentDomain;
import com.example.demo.model.request.CommentRequest;
import com.example.demo.model.response.CommentResponse;
import org.springframework.stereotype.Component;

@Component

public class ConverterCommentDB {

    public static CommentDomain convertCommentRequestToDomain (CommentRequest comment){
        return CommentDomain.builder()
                .postId(comment.getPostId())
                .name(comment.getName())
                .email(comment.getEmail())
                .body(comment.getBody())
                .build();
    }

    public static CommentResponse convertCommentDomainToResponse (CommentDomain comment){
        return CommentResponse.builder()
                .postId(comment.getPostId())
                .id(comment.getId())
                .name(comment.getName())
                .email(comment.getEmail())
                .body(comment.getBody())
                .build();
    }
}

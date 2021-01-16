package com.example.demo.model.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder

public class CompleteUserPostResponse {

    private String title;
    private String body;
    private List<CompleteUserCommentResponse> comments;

}

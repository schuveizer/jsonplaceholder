package com.example.demo.model.request.unit;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Builder

public class CommentRequest {

    @NotNull
    private String postId;
    private String name;
    private String email;
    private String body;

}

package com.example.demo.model.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class CompleteUserCommentResponse {

    private String name;
    private String email;
    private String body;

}

package com.example.demo.model.response.unit;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder

public class CommentResponse {

    private String postId;
    private String id;
    private String name;
    private String email;
    private String body;

}

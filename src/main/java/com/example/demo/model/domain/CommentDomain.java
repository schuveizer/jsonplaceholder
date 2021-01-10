package com.example.demo.model.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document (collection = "comment")

public class CommentDomain {

    private String postId;
    @Id
    private String id;
    private String name;
    private String email;
    private String body;

}

package com.example.demo.model.domain.unit;

import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document (collection = "comment")

public class CommentDomain {

    private ObjectId postId;
    @Id
    private ObjectId id;
    private String name;
    private String email;
    private String body;

}

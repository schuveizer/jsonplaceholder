package com.example.demo.model.domain.unit;

import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document (collection = "post")

public class PostDomain {

    private ObjectId userId;
    @Id
    private ObjectId id;
    private String title;
    private String body;

}

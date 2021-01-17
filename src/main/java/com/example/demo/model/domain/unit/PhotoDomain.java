package com.example.demo.model.domain.unit;

import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document (collection = "photo")

public class PhotoDomain {

    private ObjectId albumId;
    @Id
    private ObjectId id;
    private String title;
    private String url;
    private String thumbnailUrl;

}

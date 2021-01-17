package com.example.demo.model.domain.unit;

import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document (collection = "album")

public class AlbumDomain {

    private ObjectId userId;
    @Id
    private ObjectId id;
    private String title;

}

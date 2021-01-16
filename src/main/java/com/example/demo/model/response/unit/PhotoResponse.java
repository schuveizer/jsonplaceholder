package com.example.demo.model.response.unit;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class PhotoResponse {

    private String albumId;
    private String id;
    private String title;
    private String url;
    private String thumbnailUrl;

}

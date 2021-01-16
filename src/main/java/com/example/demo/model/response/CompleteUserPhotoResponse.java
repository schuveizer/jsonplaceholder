package com.example.demo.model.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class CompleteUserPhotoResponse {

    private String title;
    private String url;
    private String thumbnailUrl;

}

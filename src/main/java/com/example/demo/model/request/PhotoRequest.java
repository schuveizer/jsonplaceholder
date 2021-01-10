package com.example.demo.model.request;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Builder

public class PhotoRequest {

    @NotNull
    private String albumId;
    private String title;
    private String url;
    private String thumbnailUrl;

}

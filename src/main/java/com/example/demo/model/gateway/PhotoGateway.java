package com.example.demo.model.gateway;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class PhotoGateway {

    private Integer albumId;
    private Integer id;
    private String title;
    private String url;
    private String thumbnailUrl;

}

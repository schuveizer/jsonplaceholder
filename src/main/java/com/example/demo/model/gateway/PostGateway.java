package com.example.demo.model.gateway;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class PostGateway {

    private Integer userId;
    private Integer id;
    private String title;
    private String body;

}
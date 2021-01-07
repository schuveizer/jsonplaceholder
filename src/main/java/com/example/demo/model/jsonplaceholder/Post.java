package com.example.demo.model.jsonplaceholder;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class Post {

    private Integer userId;
    private Integer id;
    private String title;
    private String body;

}
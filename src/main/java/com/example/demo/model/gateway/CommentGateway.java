package com.example.demo.model.gateway;


import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class CommentGateway {

    private Integer postId;
    private Integer id;
    private String name;
    private String email;
    private String body;

}

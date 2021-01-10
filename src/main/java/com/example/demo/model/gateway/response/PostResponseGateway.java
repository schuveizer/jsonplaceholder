package com.example.demo.model.gateway.response;

import com.example.demo.model.gateway.CommentGateway;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder

public class PostResponseGateway {

    private Integer userId;
    private Integer id;
    private String title;
    private String body;
    private List<CommentGateway> commentGateways;

}
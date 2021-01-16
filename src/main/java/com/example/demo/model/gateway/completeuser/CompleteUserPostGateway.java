package com.example.demo.model.gateway.completeuser;

import com.example.demo.model.gateway.CommentGateway;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder

public class CompleteUserPostGateway {

    private Integer userId;
    private Integer id;
    private String title;
    private String body;
    private List<CommentGateway> comments;

}
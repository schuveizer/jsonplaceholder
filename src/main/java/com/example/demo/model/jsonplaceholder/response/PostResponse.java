package com.example.demo.model.jsonplaceholder.response;

import com.example.demo.model.jsonplaceholder.Comment;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder

public class PostResponse {

    private Integer userId;
    private Integer id;
    private String title;
    private String body;
    private List<Comment> comments;

}
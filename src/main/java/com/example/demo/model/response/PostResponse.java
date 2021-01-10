package com.example.demo.model.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class PostResponse {

    private String userId;
    private String id;
    private String title;
    private String body;

}

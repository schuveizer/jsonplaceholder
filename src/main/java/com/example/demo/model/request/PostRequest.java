package com.example.demo.model.request;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Builder

public class PostRequest {

    @NotNull
    private String userId;
    private String title;
    private String body;

}

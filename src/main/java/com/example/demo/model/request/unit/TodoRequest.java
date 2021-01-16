package com.example.demo.model.request.unit;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Builder

public class TodoRequest {

    @NotNull
    private String userId;
    private String title;
    private Boolean completed;

}

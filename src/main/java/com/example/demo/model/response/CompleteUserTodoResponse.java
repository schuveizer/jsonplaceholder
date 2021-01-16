package com.example.demo.model.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class CompleteUserTodoResponse {

    private String title;
    private Boolean completed;

}

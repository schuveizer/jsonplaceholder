package com.example.demo.model.dto.completeuser;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class CompleteUserCommentDTO {

    private String name;
    private String email;
    private String body;

}

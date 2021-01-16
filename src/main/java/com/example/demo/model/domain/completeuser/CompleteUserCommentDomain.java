package com.example.demo.model.domain.completeuser;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder

public class CompleteUserCommentDomain {

    private String name;
    private String email;
    private String body;

}

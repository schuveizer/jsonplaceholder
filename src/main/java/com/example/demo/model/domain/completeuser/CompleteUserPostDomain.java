package com.example.demo.model.domain.completeuser;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder

public class CompleteUserPostDomain {

    private String title;
    private String body;
    private List<CompleteUserCommentDomain> comments;

}

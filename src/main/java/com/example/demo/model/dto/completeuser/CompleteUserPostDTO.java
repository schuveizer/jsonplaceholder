package com.example.demo.model.dto.completeuser;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder

public class CompleteUserPostDTO {

    private String title;
    private String body;
    @NotNull
    private List<CompleteUserCommentDTO> comments;
}

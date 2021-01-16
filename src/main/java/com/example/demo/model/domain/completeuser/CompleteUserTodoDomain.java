package com.example.demo.model.domain.completeuser;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class CompleteUserTodoDomain {

    private String title;
    private Boolean completed;

}

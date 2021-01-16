package com.example.demo.model.domain.completeuser;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class CompleteUserPhotoDomain {

    private String title;
    private String url;
    private String thumbnailUrl;

}

package com.example.demo.model.dto.completeuser;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class CompleteUserPhotoDTO {

    private String title;
    private String url;
    private String thumbnailUrl;

}

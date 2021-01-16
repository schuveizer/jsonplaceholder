package com.example.demo.model.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder

public class CompleteUserAlbumResponse {

    private String title;
    private List<CompleteUserPhotoResponse> photos;

}

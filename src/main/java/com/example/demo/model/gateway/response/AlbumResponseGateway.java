package com.example.demo.model.jsonplaceholder.response;

import com.example.demo.model.jsonplaceholder.Photo;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder

public class AlbumResponse {

    private Integer userId;
    private Integer id;
    private String title;
    private List<Photo> photos;

}

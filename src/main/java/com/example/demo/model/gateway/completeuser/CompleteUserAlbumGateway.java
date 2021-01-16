package com.example.demo.model.gateway.completeuser;

import com.example.demo.model.gateway.PhotoGateway;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder

public class CompleteUserAlbumGateway {

    private Integer userId;
    private Integer id;
    private String title;
    private List<PhotoGateway> photos;

}

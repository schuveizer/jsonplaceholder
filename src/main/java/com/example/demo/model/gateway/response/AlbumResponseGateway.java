package com.example.demo.model.gateway.response;

import com.example.demo.model.gateway.PhotoGateway;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder

public class AlbumResponseGateway {

    private Integer userId;
    private Integer id;
    private String title;
    private List<PhotoGateway> photoGateways;

}

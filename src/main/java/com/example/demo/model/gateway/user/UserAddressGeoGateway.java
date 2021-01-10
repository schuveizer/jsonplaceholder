package com.example.demo.model.gateway.user;


import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class UserAddressGeoGateway {

    private String lat;
    private String lng;

}

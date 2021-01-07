package com.example.demo.model.jsonplaceholder.user;


import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class UserAddressGeo {

    private String lat;
    private String lng;

}

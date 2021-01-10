package com.example.demo.model.gateway.user;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class UserAddressGateway {

    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private UserAddressGeoGateway geo;

}

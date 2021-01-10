package com.example.demo.model.dto.user;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class UserAddressDTO {

    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private UserAddressGeoDTO geo;

}

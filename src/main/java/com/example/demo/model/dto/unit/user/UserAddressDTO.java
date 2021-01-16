package com.example.demo.model.dto.unit.user;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Builder

public class UserAddressDTO {

    private String street;
    private String suite;
    private String city;
    private String zipcode;
    @NotNull
    private UserAddressGeoDTO geo;

}

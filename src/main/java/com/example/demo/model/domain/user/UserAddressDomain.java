package com.example.demo.model.domain.user;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class UserAddressDomain {

    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private UserAddressGeoDomain geo;

}

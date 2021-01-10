package com.example.demo.model.domain.user;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class UserAddressGeoDomain {

    private String lat;
    private String lng;

}

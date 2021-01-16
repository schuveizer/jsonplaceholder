package com.example.demo.model.domain.unit.user;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class UserAddressGeoDomain {

    private Double lat;
    private Double lng;

}

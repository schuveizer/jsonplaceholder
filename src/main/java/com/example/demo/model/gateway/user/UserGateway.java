package com.example.demo.model.gateway.user;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class UserGateway {

    private Integer id;
    private String name;
    private String username;
    private String email;
    private UserAddressGateway address;
    private String phone;
    private String website;
    private UserCompanyGateway company;

}

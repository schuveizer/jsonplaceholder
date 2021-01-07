package com.example.demo.model.jsonplaceholder.user;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class User {

    private Integer id;
    private String name;
    private String username;
    private String email;
    private UserAddress address;
    private String phone;
    private String website;
    private UserCompany company;

}

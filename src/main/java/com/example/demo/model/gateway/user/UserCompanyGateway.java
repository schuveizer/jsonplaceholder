package com.example.demo.model.gateway.user;


import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class UserCompanyGateway {

    private String name;
    private String catchPhrase;
    private String bs;

}

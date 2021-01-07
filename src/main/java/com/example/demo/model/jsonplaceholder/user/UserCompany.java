package com.example.demo.model.jsonplaceholder.user;


import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class UserCompany {

    private String name;
    private String catchPhrase;
    private String bs;

}

package com.example.demo.model.domain.unit.user;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class UserCompanyDomain {

    private String name;
    private String catchPhrase;
    private String bs;

}

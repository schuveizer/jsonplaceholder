package com.example.demo.model.dto.unit.user;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class UserCompanyDTO {

    private String name;
    private String catchPhrase;
    private String bs;

}

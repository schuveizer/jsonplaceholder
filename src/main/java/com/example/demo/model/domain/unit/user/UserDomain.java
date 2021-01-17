package com.example.demo.model.domain.unit.user;

import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document (collection = "user")

public class UserDomain {

    @Id
    private ObjectId id;
    private String name;
    private String username;
    private String email;
    private UserAddressDomain address;
    private String phone;
    private String website;
    private UserCompanyDomain company;

}

package com.example.demo.model.domain.user;

import com.example.demo.model.domain.user.UserAddressDomain;
import com.example.demo.model.domain.user.UserCompanyDomain;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document (collection = "user")

public class UserDomain {

    @Id
    private String id;
    private String name;
    private String username;
    private String email;
    private UserAddressDomain address;
    private String phone;
    private String website;
    private UserCompanyDomain company;

}

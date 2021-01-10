package com.example.demo.model.response;

import com.example.demo.model.dto.user.UserAddressDTO;
import com.example.demo.model.dto.user.UserCompanyDTO;
import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class UserResponse {

    private String id;
    private String name;
    private String username;
    private String email;
    private UserAddressDTO address;
    private String phone;
    private String website;
    private UserCompanyDTO company;

}

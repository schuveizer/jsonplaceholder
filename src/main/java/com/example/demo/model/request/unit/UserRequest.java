package com.example.demo.model.request.unit;

import com.example.demo.model.dto.unit.user.UserAddressDTO;
import com.example.demo.model.dto.unit.user.UserCompanyDTO;
import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class UserRequest {

    private String name;
    private String username;
    private String email;
    private UserAddressDTO address;
    private String phone;
    private String website;
    private UserCompanyDTO company;

}

package com.example.demo.model.gateway.response;

import com.example.demo.model.gateway.TodoGateway;
import com.example.demo.model.gateway.user.UserAddressGateway;
import com.example.demo.model.gateway.user.UserCompanyGateway;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder

public class UserResponseGateway {

    private Integer id;
    private String name;
    private String username;
    private String email;
    private UserAddressGateway address;
    private String phone;
    private String website;
    private UserCompanyGateway company;
    private List<PostResponseGateway> posts;
    private List<AlbumResponseGateway> albums;
    private List<TodoGateway> todoGateways;

}

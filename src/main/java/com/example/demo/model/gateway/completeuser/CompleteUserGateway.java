package com.example.demo.model.gateway.completeuser;

import com.example.demo.model.gateway.TodoGateway;
import com.example.demo.model.gateway.user.UserAddressGateway;
import com.example.demo.model.gateway.user.UserCompanyGateway;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder

public class CompleteUserGateway {

    private Integer id;
    private String name;
    private String username;
    private String email;
    private UserAddressGateway address;
    private String phone;
    private String website;
    private UserCompanyGateway company;
    private List<CompleteUserPostGateway> posts;
    private List<CompleteUserAlbumGateway> albums;
    private List<TodoGateway> todos;

}

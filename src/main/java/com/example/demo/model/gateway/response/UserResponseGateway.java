package com.example.demo.model.jsonplaceholder.response;

import com.example.demo.model.jsonplaceholder.Todo;
import com.example.demo.model.jsonplaceholder.user.UserAddress;
import com.example.demo.model.jsonplaceholder.user.UserCompany;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder

public class UserResponse {

    private Integer id;
    private String name;
    private String username;
    private String email;
    private UserAddress address;
    private String phone;
    private String website;
    private UserCompany company;
    private List<PostResponse> posts;
    private List<AlbumResponse> albums;
    private List<Todo> todos;

}

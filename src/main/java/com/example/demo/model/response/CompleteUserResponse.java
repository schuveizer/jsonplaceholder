package com.example.demo.model.response;

import com.example.demo.model.dto.completeuser.CompleteUserAlbumDTO;
import com.example.demo.model.dto.completeuser.CompleteUserPostDTO;
import com.example.demo.model.dto.completeuser.CompleteUserTodoDTO;
import com.example.demo.model.dto.unit.user.UserAddressDTO;
import com.example.demo.model.dto.unit.user.UserCompanyDTO;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@Builder

public class CompleteUserResponse {

    private String id;
    private String name;
    private String username;
    private String email;
    private UserAddressDTO address;
    private String phone;
    private String website;
    private UserCompanyDTO company;
    private List<CompleteUserPostDTO> posts;
    private List<CompleteUserAlbumDTO> albums;
    private List<CompleteUserTodoDTO> todos;

}

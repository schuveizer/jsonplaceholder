package com.example.demo.model.request;

import com.example.demo.model.dto.completeuser.CompleteUserAlbumDTO;
import com.example.demo.model.dto.completeuser.CompleteUserPostDTO;
import com.example.demo.model.dto.completeuser.CompleteUserTodoDTO;
import com.example.demo.model.dto.unit.user.UserAddressDTO;
import com.example.demo.model.dto.unit.user.UserCompanyDTO;
import lombok.Builder;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder

public class CompleteUserRequest {

    private String name;
    private String username;
    private String email;
    @NotNull @Valid
    private UserAddressDTO address;
    private String phone;
    private String website;
    @NotNull
    private UserCompanyDTO company;
    @NotNull @Valid
    private List<CompleteUserPostDTO> posts;
    @NotNull @Valid
    private List<CompleteUserAlbumDTO> albums;
    @NotNull
    private List<CompleteUserTodoDTO> todos;

}

package com.example.demo.model.domain.completeuser;

import com.example.demo.model.domain.unit.user.UserAddressDomain;
import com.example.demo.model.domain.unit.user.UserCompanyDomain;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Builder
@Document (collection = "complete_user")

public class CompleteUserDomain {

    @Id
    private String id;
    private String name;
    private String username;
    private String email;
    private UserAddressDomain address;
    private String phone;
    private String website;
    private UserCompanyDomain company;
    private List<CompleteUserPostDomain> posts;
    private List<CompleteUserAlbumDomain> albums;
    private List<CompleteUserTodoDomain> todos;

}

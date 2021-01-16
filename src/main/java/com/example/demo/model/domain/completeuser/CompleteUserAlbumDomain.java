package com.example.demo.model.domain.completeuser;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder

public class CompleteUserAlbumDomain {

    private String title;
    private List<CompleteUserPhotoDomain> photos;

}

package com.example.demo.model.dto.completeuser;


import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder

public class CompleteUserAlbumDTO {

    private String title;
    @NotNull
    private List<CompleteUserPhotoDTO> photos;

}

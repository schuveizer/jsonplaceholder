package com.example.demo.utils.db;

import com.example.demo.model.domain.AlbumDomain;
import com.example.demo.model.request.AlbumRequest;
import com.example.demo.model.response.AlbumResponse;
import org.springframework.stereotype.Component;

@Component

public class ConverterAlbumDB {

    public static AlbumDomain convertAlbumRequestToDomain(AlbumRequest album){
        return AlbumDomain.builder()
            .userId(album.getUserId())
            .title(album.getTitle())
        .build();
    }

    public static AlbumResponse convertAlbumDomainToResponse (AlbumDomain album){
        return AlbumResponse.builder()
                .userId(album.getUserId())
                .id(album.getId())
                .title(album.getTitle())
                .build();
    }
}

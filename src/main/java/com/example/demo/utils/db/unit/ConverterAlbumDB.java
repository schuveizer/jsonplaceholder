package com.example.demo.utils.db.unit;

import com.example.demo.model.domain.unit.AlbumDomain;
import com.example.demo.model.gateway.AlbumGateway;
import com.example.demo.model.request.unit.AlbumRequest;
import com.example.demo.model.response.unit.AlbumResponse;
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

    public static AlbumDomain convertAlbumGatewayToDomain (AlbumGateway album){
        return AlbumDomain.builder()
                .title(album.getTitle())
                .build();
    }

    public static AlbumDomain convertAlbumGatewayToDomainWithUserId (AlbumGateway album, String userId){
        return AlbumDomain.builder()
                .userId(userId)
                .title(album.getTitle())
                .build();
    }

}

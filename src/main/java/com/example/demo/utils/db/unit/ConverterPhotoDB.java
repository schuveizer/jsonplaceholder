package com.example.demo.utils.db.unit;

import com.example.demo.model.domain.completeuser.CompleteUserPhotoDomain;
import com.example.demo.model.domain.unit.PhotoDomain;
import com.example.demo.model.gateway.PhotoGateway;
import com.example.demo.model.request.unit.PhotoRequest;
import com.example.demo.model.response.unit.PhotoResponse;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

@Component

public class ConverterPhotoDB {

    public static PhotoDomain convertPhotoRequestToDomain (PhotoRequest photo){
        return PhotoDomain.builder()
                .albumId(new ObjectId(photo.getAlbumId()))
                .title(photo.getTitle())
                .url(photo.getUrl())
                .thumbnailUrl(photo.getThumbnailUrl())
                .build();
    }

    public static PhotoResponse convertPhotoDomainToResponse (PhotoDomain photo){
        return PhotoResponse.builder()
                .albumId(photo.getAlbumId().toHexString())
                .id(photo.getId().toHexString())
                .title(photo.getTitle())
                .url(photo.getUrl())
                .thumbnailUrl(photo.getThumbnailUrl())
                .build();
    }

    public static PhotoDomain convertPhotoGatewayToDomain(PhotoGateway photo) {
        return PhotoDomain.builder()
                .title(photo.getTitle())
                .url(photo.getUrl())
                .thumbnailUrl(photo.getThumbnailUrl())
                .build();
    }

    public static PhotoDomain convertPhotoGatewayToDomainWithAlbumId(PhotoGateway photo, String albumId) {
        return PhotoDomain.builder()
                .albumId(new ObjectId(albumId))
                .title(photo.getTitle())
                .url(photo.getUrl())
                .thumbnailUrl(photo.getThumbnailUrl())
                .build();
    }

}

package com.example.demo.utils.db;

import com.example.demo.model.domain.PhotoDomain;
import com.example.demo.model.request.PhotoRequest;
import com.example.demo.model.response.PhotoResponse;
import org.springframework.stereotype.Component;

@Component

public class ConverterPhotoDB {

    public static PhotoDomain convertPhotoRequestToDomain (PhotoRequest photo){
        return PhotoDomain.builder()
                .albumId(photo.getAlbumId())
                .title(photo.getTitle())
                .url(photo.getUrl())
                .thumbnailUrl(photo.getThumbnailUrl())
                .build();
    }

    public static PhotoResponse convertPhotoDomainToResponse (PhotoDomain photo){
        return PhotoResponse.builder()
                .albumId(photo.getAlbumId())
                .id(photo.getId())
                .title(photo.getTitle())
                .url(photo.getUrl())
                .thumbnailUrl(photo.getThumbnailUrl())
                .build();
    }
}

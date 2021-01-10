package com.example.demo.service.db;

import com.example.demo.model.domain.PhotoDomain;
import com.example.demo.model.request.AlbumRequest;
import com.example.demo.model.request.PhotoRequest;
import com.example.demo.model.response.AlbumResponse;
import com.example.demo.model.response.PhotoResponse;
import com.example.demo.repository.AlbumRepository;
import com.example.demo.repository.PhotoRepository;
import com.example.demo.utils.db.ConverterPhotoDB;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class PhotoService {

    private final PhotoRepository photoRepository;
    private final AlbumRepository albumRepository;

    public List<PhotoResponse> getAll() {
        List<PhotoDomain> photos = photoRepository.findAll();
        return photos.stream().map(ConverterPhotoDB::convertPhotoDomainToResponse)
                .collect(Collectors.toList());
    }

    public PhotoResponse getById(String id) {
        PhotoDomain photo = photoRepository.findById(id).orElseThrow();
        return ConverterPhotoDB.convertPhotoDomainToResponse(photo);
    }

    public PhotoResponse create(PhotoRequest request) {
        albumRepository.findById(request.getAlbumId()).orElseThrow();
        PhotoDomain photo = ConverterPhotoDB.convertPhotoRequestToDomain(request);
        photo = photoRepository.insert(photo);
        return ConverterPhotoDB.convertPhotoDomainToResponse(photo);
    }

    public PhotoResponse update(PhotoRequest request, String id) {
        albumRepository.findById(request.getAlbumId()).orElseThrow();
        getById(id);
        PhotoDomain photo = ConverterPhotoDB.convertPhotoRequestToDomain(request);
        photo.setId(id);
        photo = photoRepository.save(photo);
        return ConverterPhotoDB.convertPhotoDomainToResponse(photo);
    }

    public void delete (String id){
        getById(id);
        photoRepository.deleteById(id);
    }
}

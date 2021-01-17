package com.example.demo.service.db.unit;

import com.example.demo.model.domain.unit.CommentDomain;
import com.example.demo.model.domain.unit.PhotoDomain;
import com.example.demo.model.domain.unit.PostDomain;
import com.example.demo.model.request.unit.PhotoRequest;
import com.example.demo.model.response.unit.PhotoResponse;
import com.example.demo.repository.unit.AlbumRepository;
import com.example.demo.repository.unit.PhotoRepository;
import com.example.demo.utils.db.unit.ConverterPhotoDB;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
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
        photo.setId(new ObjectId(id));
        photo = photoRepository.save(photo);
        return ConverterPhotoDB.convertPhotoDomainToResponse(photo);
    }

    public void delete (String id){
        getById(id);
        photoRepository.deleteById(id);
    }

    public void deleteByAlbumId (String albumId){
        List<PhotoDomain> photos  = photoRepository.findByAlbumId(albumId);
        photoRepository.deleteAll(photos);
    }

    public List<PhotoDomain> fullLoad(List<PhotoDomain> photos){
        return photoRepository.saveAll(photos);
    }

    public void purgeDB(){
        photoRepository.deleteAll();
    }
}

package com.example.demo.service.db.unit;

import com.example.demo.model.domain.unit.AlbumDomain;
import com.example.demo.model.request.unit.AlbumRequest;
import com.example.demo.model.response.unit.AlbumResponse;
import com.example.demo.repository.unit.AlbumRepository;
import com.example.demo.repository.unit.UserRepository;
import com.example.demo.utils.db.unit.ConverterAlbumDB;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class AlbumService {

    private final AlbumRepository albumRepository;
    private final UserRepository userRepository;
    private final PhotoService photoService;

    public List<AlbumResponse> getAll (){
        List<AlbumDomain> albums = albumRepository.findAll();
        return albums.stream().map(ConverterAlbumDB::convertAlbumDomainToResponse)
                .collect(Collectors.toList());
    }

    public AlbumResponse getById (String id){
        AlbumDomain album = albumRepository.findById(id).orElseThrow();
        return ConverterAlbumDB.convertAlbumDomainToResponse(album);
    }

    public AlbumResponse create (AlbumRequest request){
        userRepository.findById(request.getUserId()).orElseThrow();
        AlbumDomain album = ConverterAlbumDB.convertAlbumRequestToDomain(request);
        album = albumRepository.insert(album);
        return ConverterAlbumDB.convertAlbumDomainToResponse(album);
    }

    public AlbumDomain strictCreate(AlbumDomain album){
        return albumRepository.insert(album);
    }

    public AlbumResponse update (AlbumRequest request, String id){
        userRepository.findById(request.getUserId()).orElseThrow();
        getById(id);
        AlbumDomain album = ConverterAlbumDB.convertAlbumRequestToDomain(request);
        album.setId(new ObjectId(id));
        album = albumRepository.save(album);
        return ConverterAlbumDB.convertAlbumDomainToResponse(album);
    }

    public void delete (String id){
        getById(id);
        photoService.deleteByAlbumId(id);
        albumRepository.deleteById(id);
    }

    public List<AlbumDomain> findByUserId (String userId){
        return albumRepository.findByUserId(userId);
    }

    public List<AlbumDomain> fullLoad(List<AlbumDomain> albums){
        return albumRepository.saveAll(albums);
    }

    public void purgeDB(){
        albumRepository.deleteAll();
    }

}

package com.example.demo.service.db;

import com.example.demo.model.domain.AlbumDomain;
import com.example.demo.model.request.AlbumRequest;
import com.example.demo.model.response.AlbumResponse;
import com.example.demo.repository.AlbumRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.utils.db.ConverterAlbumDB;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class AlbumService {

    private final AlbumRepository albumRepository;
    private final UserRepository userRepository;

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

    public AlbumResponse update (AlbumRequest request, String id){
        userRepository.findById(request.getUserId()).orElseThrow();
        getById(id);
        AlbumDomain album = ConverterAlbumDB.convertAlbumRequestToDomain(request);
        album.setId(id);
        album = albumRepository.save(album);
        return ConverterAlbumDB.convertAlbumDomainToResponse(album);
    }

    public void delete (String id){
        getById(id);
        albumRepository.deleteById(id);
    }
}

package com.example.demo.repository.unit;


import com.example.demo.model.domain.unit.CommentDomain;
import com.example.demo.model.domain.unit.PhotoDomain;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface PhotoRepository extends MongoRepository <PhotoDomain, String> {

    List<PhotoDomain> findByAlbumId (String albumId);

}

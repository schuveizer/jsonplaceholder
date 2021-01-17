package com.example.demo.repository.unit;

import com.example.demo.model.domain.unit.AlbumDomain;
import com.example.demo.model.domain.unit.TodoDomain;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface AlbumRepository extends MongoRepository <AlbumDomain, String> {

    List<AlbumDomain> findByUserId (String userId);

}

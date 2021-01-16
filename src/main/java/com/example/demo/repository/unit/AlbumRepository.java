package com.example.demo.repository.unit;

import com.example.demo.model.domain.unit.AlbumDomain;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface AlbumRepository extends MongoRepository <AlbumDomain, String> {
}

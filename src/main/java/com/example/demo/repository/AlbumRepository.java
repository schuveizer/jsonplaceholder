package com.example.demo.repository;

import com.example.demo.model.domain.AlbumDomain;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface AlbumRepository extends MongoRepository <AlbumDomain, String> {
}

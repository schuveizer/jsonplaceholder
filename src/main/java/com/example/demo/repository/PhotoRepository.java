package com.example.demo.repository;


import com.example.demo.model.domain.PhotoDomain;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface PhotoRepository extends MongoRepository <PhotoDomain, String> {
}

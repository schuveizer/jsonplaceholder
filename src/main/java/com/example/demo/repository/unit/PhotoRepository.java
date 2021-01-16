package com.example.demo.repository.unit;


import com.example.demo.model.domain.unit.PhotoDomain;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface PhotoRepository extends MongoRepository <PhotoDomain, String> {
}

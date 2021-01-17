package com.example.demo.repository.unit.template;

import com.example.demo.model.domain.unit.PostDomain;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface PostTemplateRepository {

    List<PostDomain> getPostByUserGeo (Double minLat, Double maxLat, Double minLng, Double maxLng);
}

package com.example.demo.repository.unit;

import com.example.demo.model.domain.unit.PostDomain;
import com.example.demo.repository.unit.template.PostTemplateRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface PostRepository extends MongoRepository <PostDomain, String>, PostTemplateRepository {

    List<PostDomain> findByUserId (String userId);

}

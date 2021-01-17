package com.example.demo.repository.unit;

import com.example.demo.model.domain.unit.CommentDomain;
import com.example.demo.model.domain.unit.TodoDomain;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface CommentRepository extends MongoRepository <CommentDomain, String> {

    List<CommentDomain> findByPostId (String postId);

}

package com.example.demo.repository.unit;


import com.example.demo.model.domain.unit.user.UserDomain;
import com.example.demo.repository.unit.template.UserTemplateRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface UserRepository extends MongoRepository <UserDomain, String>, UserTemplateRepository {

    List<UserDomain> findByName (String name);

}

package com.example.demo.repository.unit.template;

import com.example.demo.model.domain.completeuser.CompleteUserDomain;
import com.example.demo.model.domain.unit.user.UserDomain;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface UserTemplateRepository {

    List<UserDomain> getUserByLatLngRange (Double minLat, Double maxLat, Double minLng, Double maxLng);
    List<CompleteUserDomain> getCompleteUsers ();

}

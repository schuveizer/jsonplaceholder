package com.example.demo.repository.unit.template.impl;


import com.example.demo.model.domain.unit.PostDomain;
import com.example.demo.model.domain.unit.user.UserDomain;
import com.example.demo.repository.unit.template.PostTemplateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.LookupOperation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;


import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;

@RequiredArgsConstructor

public class PostTemplateRepositoryImpl implements PostTemplateRepository {

    private final MongoTemplate mongoTemplate;
    private static final String USER_DB = "user";
    private static final String POST_DB = "post";
    private static final String USER_ID = "userId";
    private static final String FOREIGN_USER_ID = "_id";
    private static final String AS_USER = "user";
    private static final String FOREIGN_USER_GEO_LAT = "user.address.geo.lat";
    private static final String FOREIGN_USER_GEO_LNG = "user.address.geo.lng";

    @Override
    public List<PostDomain> getPostByUserGeo(Double minLat, Double maxLat, Double minLng, Double maxLng) {
       MatchOperation matchOperation = match(where(FOREIGN_USER_GEO_LAT)
               .gte(minLat)
               .lte(maxLat)
               .and(FOREIGN_USER_GEO_LNG)
                 .gte(minLng)
                 .lte(maxLng));
        Aggregation aggregation = newAggregation(userLookUp(), matchOperation);
        return mongoTemplate.aggregate(aggregation, POST_DB, PostDomain.class).getMappedResults();
    }

    public LookupOperation userLookUp (){
        return new LookupOperation.LookupOperationBuilder()
                .from(USER_DB)
                .localField(USER_ID)
                .foreignField(FOREIGN_USER_ID)
                .as(AS_USER);
    }

}

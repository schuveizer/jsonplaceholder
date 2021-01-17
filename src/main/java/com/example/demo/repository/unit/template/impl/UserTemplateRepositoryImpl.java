package com.example.demo.repository.unit.template.impl;


import com.example.demo.model.domain.completeuser.CompleteUserDomain;
import com.example.demo.model.domain.unit.user.UserDomain;
import com.example.demo.repository.unit.template.UserTemplateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.*;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.LookupOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;
import static org.springframework.data.mongodb.core.query.Criteria.where;


import java.util.List;

@RequiredArgsConstructor

public class UserTemplateRepositoryImpl implements UserTemplateRepository {

    private final MongoTemplate mongoTemplate;
    private static final String USER_DB = "user";
    private static final String ALBUM_DB = "album";
    private static final String PHOTO_DB = "photo";
    private static final String POST_DB = "post";
    private static final String COMMENT_DB = "comment";
    private static final String TODO_DB = "todo";

    private static final String USER_ID = "_id";
    private static final String POST_ID = "post._id";
    private static final String ALBUM_ID = "album._id";

    private static final String POST_LOOKUP_FIELD = "posts";
    private static final String COMMENT_LOOKUP_FIELD = "post.comments";
    private static final String ALBUM_LOOKUP_FIELD = "albums";
    private static final String PHOTO_LOOKUP_FIELD = "album.photos";
    private static final String TODO_LOOKUP_FIELD = "todos";

    private static final String POST_UNWIND_FIELD = "post";
    private static final String ALBUM_UNWIND_FIELD = "album";

    private static final String FOREIGN_USER_ID = "userId";
    private static final String FOREIGN_ALBUM_ID = "albumId";
    private static final String FOREIGN_POST_ID = "postId";

    private static final String USER_GEO_LAT = "address.geo.lat";
    private static final String USER_GEO_LNG = "address.geo.lng";

    @Override
    public List<UserDomain> getUserByLatLngRange(Double minLat, Double maxLat, Double minLng, Double maxLng) {
        Query query = new Query();
        Criteria criteria = where(USER_GEO_LAT).gte(minLat).lte(maxLat).and(USER_GEO_LNG).gte(minLng).lte(maxLng);
        query.addCriteria(criteria);
        return mongoTemplate.find(query, UserDomain.class);
    }

    @Override
    public List<CompleteUserDomain> getCompleteUsers() {
        Aggregation aggregation = newAggregation(albumLookUp(), postLookUp(), todoLookUp());
        return mongoTemplate.aggregate(aggregation, USER_DB, CompleteUserDomain.class).getMappedResults();
    }

    public LookupOperation albumLookUp (){
        return new LookupOperation.LookupOperationBuilder()
                .from(ALBUM_DB)
                .localField(USER_ID)
                .foreignField(FOREIGN_USER_ID)
                .as(ALBUM_LOOKUP_FIELD);
    }

//    public LookupOperation photoLookUp (){
//        return new LookupOperation.LookupOperationBuilder()
//                .from(USER_DB)
//                .localField(USER_ID)
//                .foreignField(FOREIGN_USER_ID)
//                .as(AS_USER);
//    }

    public LookupOperation postLookUp (){
        return new LookupOperation.LookupOperationBuilder()
                .from(POST_DB)
                .localField(USER_ID)
                .foreignField(FOREIGN_USER_ID)
                .as(POST_LOOKUP_FIELD);
    }

//    public LookupOperation commentLookUp (){
//        return new LookupOperation.LookupOperationBuilder()
//                .from(USER_DB)
//                .localField(USER_ID)
//                .foreignField(FOREIGN_USER_ID)
//                .as(AS_USER);
//    }

    public LookupOperation todoLookUp (){
        return new LookupOperation.LookupOperationBuilder()
                .from(TODO_DB)
                .localField(USER_ID)
                .foreignField(FOREIGN_USER_ID)
                .as(TODO_LOOKUP_FIELD);
    }

}

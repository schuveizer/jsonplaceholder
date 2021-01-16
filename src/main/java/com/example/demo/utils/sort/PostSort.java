package com.example.demo.utils.sort;

import com.example.demo.model.domain.unit.PostDomain;
import com.example.demo.model.gateway.PostGateway;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component

public class PostSort {

    public static List<PostDomain> sortDomain(List<PostDomain> posts){
        return posts.stream().sorted((post1, post2) -> {
            if (post1.getTitle().compareTo(post2.getTitle()) != 0)
                return post1.getTitle().compareTo(post2.getTitle());

            return post1.getBody().compareTo(post2.getBody());
        }).collect(Collectors.toList());
    }

    public static List<PostGateway> sortGateway(List<PostGateway> posts){
        return posts.stream().sorted((post1, post2) -> {
            if (post1.getTitle().compareTo(post2.getTitle()) != 0)
                return post1.getTitle().compareTo(post2.getTitle());

            return post1.getBody().compareTo(post2.getBody());
        }).collect(Collectors.toList());
    }



}

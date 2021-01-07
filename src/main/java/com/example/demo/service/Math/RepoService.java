package com.example.demo.service.Math;

import com.example.demo.model.jsonplaceholder.Todo;
import com.example.demo.model.jsonplaceholder.Post;
import com.example.demo.repository.JsonPlaceHolderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class RepoService {

    private final JsonPlaceHolderRepository jsonPlaceHolderRepository;

    public Todo repoTest (Integer id){
        return jsonPlaceHolderRepository.getTestRepository(id);
    }

    public List<Post> repoPostsTest (){
        return  jsonPlaceHolderRepository.getPosts();
    }

    public List<Post> repoPostsTestSearch (String search){
        List<Post> listTest;
        listTest = jsonPlaceHolderRepository.getPosts();
//        String test = "stringgg";
//        Boolean test2 = test.contains("stringgg");
        listTest = listTest.stream()
                .filter(s -> s.getBody().contains(search))
                .collect(Collectors.toList());
        return listTest;
    }

    public List<Post> repoPostsTestOdd (Boolean odd){
        List<Post> listOdd;
        listOdd = jsonPlaceHolderRepository.getPosts();
//        Boolean test = true && (false || true);
//        Boolean test2 = false || false && (true &&(false || false));
//        Boolean test3 = (true && true) || (true && false);
        listOdd = listOdd.stream()
                .filter(a -> (a.getId() % 2 != 0 && odd) || (a.getId() % 2 == 0 && !odd)  )
                .collect(Collectors.toList());
        return listOdd;
    }
}

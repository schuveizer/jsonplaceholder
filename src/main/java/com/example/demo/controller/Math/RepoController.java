package com.example.demo.controller.Math;

import com.example.demo.model.gateway.PostGateway;
import com.example.demo.model.gateway.TodoGateway;
import com.example.demo.service.math.RepoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping ("/repo")

public class RepoController {

    private final RepoService repoService;

        @GetMapping ("/{id}")
        public TodoGateway getTestRepository (@PathVariable Integer id){
            return repoService.repoTest(id);
        }

        @GetMapping ("/posts")
        public List<PostGateway> getTestRepositoryPosts (){
            return repoService.repoPostsTest();
        }

        @GetMapping ("/post")
        public List<PostGateway> repoPostsTestSearch (@RequestParam String search){
            return repoService.repoPostsTestSearch(search);
        }

        @GetMapping ("/poste")
        public List<PostGateway> repoPostsTestOdd (@RequestParam Boolean odd){
            return repoService.repoPostsTestOdd(odd);
        }
}


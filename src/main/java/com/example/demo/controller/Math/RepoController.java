package com.example.demo.controller.Math;

import com.example.demo.model.jsonplaceholder.Todo;
import com.example.demo.model.jsonplaceholder.Post;
import com.example.demo.service.Math.RepoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping ("/repo")

public class RepoController {

    private final RepoService repoService;

        @GetMapping ("/{id}")
        public Todo getTestRepository (@PathVariable Integer id){
            return repoService.repoTest(id);
        }

        @GetMapping ("/posts")
        public List<Post> getTestRepositoryPosts (){
            return repoService.repoPostsTest();
        }

        @GetMapping ("/post")
        public List<Post> repoPostsTestSearch (@RequestParam String search){
            return repoService.repoPostsTestSearch(search);
        }

        @GetMapping ("/poste")
        public List<Post> repoPostsTestOdd (@RequestParam Boolean odd){
            return repoService.repoPostsTestOdd(odd);
        }
}


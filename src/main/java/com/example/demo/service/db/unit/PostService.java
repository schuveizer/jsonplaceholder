package com.example.demo.service.db.unit;

import com.example.demo.model.domain.unit.PostDomain;
import com.example.demo.model.domain.unit.user.UserDomain;
import com.example.demo.model.request.unit.PostRequest;
import com.example.demo.model.response.unit.PostResponse;
import com.example.demo.repository.unit.PostRepository;
import com.example.demo.repository.unit.UserRepository;
import com.example.demo.utils.db.unit.ConverterPostDB;
import com.example.demo.utils.db.unit.ConverterUserDB;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final CommentService commentService;

    public List<PostResponse> getAll(){
        List<PostDomain> posts = postRepository.findAll();
        return posts.stream().map(ConverterPostDB::convertPostDomainToResponse)
                .collect(Collectors.toList());
    }

    public PostResponse getById(String id){
        PostDomain post = postRepository.findById(id).orElseThrow();
        return ConverterPostDB.convertPostDomainToResponse(post);
    }

    public List<PostResponse> getPostByUserGeo (Double minLat, Double maxLat, Double minLng, Double maxLng) {
        List<PostDomain> users = postRepository.getPostByUserGeo(minLat, maxLat, minLng, maxLng);
        return users.stream().map(ConverterPostDB::convertPostDomainToResponse)
                .collect(Collectors.toList());
    }

    public PostResponse create (PostRequest request){
        userRepository.findById(request.getUserId()).orElseThrow();
        PostDomain post = ConverterPostDB.convertPostRequestToDomain(request);
        post = postRepository.insert(post);
        return ConverterPostDB.convertPostDomainToResponse(post);
    }

    public PostDomain strictCreate(PostDomain post){
        return postRepository.insert(post);
    }

    public PostResponse update (PostRequest request, String id){
        userRepository.findById(request.getUserId()).orElseThrow();
        PostDomain post = ConverterPostDB.convertPostRequestToDomain(request);
        post.setId(new ObjectId(id));
        post = postRepository.save(post);
        return ConverterPostDB.convertPostDomainToResponse(post);
    }

    public void delete (String id){
        getById(id);
        commentService.deleteByPostId(id);
        postRepository.deleteById(id);
    }

    public List<PostDomain> findByUserId (String userId){
        return postRepository.findByUserId(userId);
    }

    public List<PostDomain> fullLoad(List<PostDomain> posts){
        return postRepository.saveAll(posts);
    }

    public void purgeDB(){
        postRepository.deleteAll();
    }
}

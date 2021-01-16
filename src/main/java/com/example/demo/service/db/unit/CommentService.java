package com.example.demo.service.db.unit;

import com.example.demo.model.domain.unit.CommentDomain;
import com.example.demo.model.domain.unit.PhotoDomain;
import com.example.demo.model.request.unit.CommentRequest;
import com.example.demo.model.response.unit.CommentResponse;
import com.example.demo.repository.unit.CommentRepository;
import com.example.demo.repository.unit.PostRepository;
import com.example.demo.utils.db.unit.ConverterCommentDB;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    public List<CommentResponse> getAll (){
        List<CommentDomain> comments = commentRepository.findAll();
        return comments.stream().map(ConverterCommentDB::convertCommentDomainToResponse)
                .collect(Collectors.toList());
    }

    public CommentResponse getById (String id){
        CommentDomain comment = commentRepository.findById(id).orElseThrow();
        return ConverterCommentDB.convertCommentDomainToResponse(comment);
    }

    public CommentResponse create (CommentRequest request){
        postRepository.findById(request.getPostId()).orElseThrow();
        CommentDomain comment = ConverterCommentDB.convertCommentRequestToDomain(request);
        comment = commentRepository.insert(comment);
        return ConverterCommentDB.convertCommentDomainToResponse(comment);
    }

    public CommentResponse update (CommentRequest request, String id){
        postRepository.findById(request.getPostId()).orElseThrow();
        getById(id);
        CommentDomain comment = ConverterCommentDB.convertCommentRequestToDomain(request);
        comment.setId(id);
        comment = commentRepository.save(comment);
        return ConverterCommentDB.convertCommentDomainToResponse(comment);
    }

    public void delete (String id){
        getById(id);
        commentRepository.deleteById(id);
    }

    public List<CommentDomain> fullLoad(List<CommentDomain> comments){
        return commentRepository.saveAll(comments);
    }

    public void purgeDB(){
        commentRepository.deleteAll();
    }

}

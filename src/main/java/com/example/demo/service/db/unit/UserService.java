package com.example.demo.service.db;

import com.example.demo.model.domain.user.UserDomain;
import com.example.demo.model.request.AlbumRequest;
import com.example.demo.model.request.UserRequest;
import com.example.demo.model.response.AlbumResponse;
import com.example.demo.model.response.UserResponse;
import com.example.demo.repository.UserRepository;
import com.example.demo.utils.db.ConverterUserDB;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class UserService {

    private final UserRepository userRepository;

    public List<UserResponse> getAll (){
        List<UserDomain> users = userRepository.findAll();
        return users.stream().map(ConverterUserDB::convertUserDomainToResponse)
                .collect(Collectors.toList());
    }

    public UserResponse getById (String id){
        UserDomain user = userRepository.findById(id).orElseThrow();
        return ConverterUserDB.convertUserDomainToResponse(user);
    }

    public UserResponse create (UserRequest request){
        UserDomain user = ConverterUserDB.convertUserRequestToDomain(request);
        user = userRepository.insert(user);
        return ConverterUserDB.convertUserDomainToResponse(user);
    }

    public UserResponse update (UserRequest request, String id){
        getById(id);
        UserDomain user = ConverterUserDB.convertUserRequestToDomain(request);
        user.setId(id);
        user = userRepository.save(user);
        return ConverterUserDB.convertUserDomainToResponse(user);
    }

    public void delete (String id){
        getById(id);
        userRepository.deleteById(id);
    }

}

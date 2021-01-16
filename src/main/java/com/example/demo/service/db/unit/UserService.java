package com.example.demo.service.db.unit;

import com.example.demo.model.domain.unit.user.UserDomain;
import com.example.demo.model.request.unit.UserRequest;
import com.example.demo.model.response.unit.UserResponse;
import com.example.demo.repository.unit.UserRepository;
import com.example.demo.utils.db.unit.ConverterUserDB;
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

    public UserDomain strictCreate(UserDomain user){
        return userRepository.insert(user);
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

    public List<UserDomain> fullLoad(List<UserDomain> users){
        return userRepository.saveAll(users);
    }

    public void purgeDB(){
        userRepository.deleteAll();
    }
}

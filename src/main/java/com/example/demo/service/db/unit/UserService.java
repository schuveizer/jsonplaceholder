package com.example.demo.service.db.unit;

import com.example.demo.model.domain.completeuser.CompleteUserDomain;
import com.example.demo.model.domain.unit.user.UserDomain;
import com.example.demo.model.request.unit.UserRequest;
import com.example.demo.model.response.unit.UserResponse;
import com.example.demo.repository.unit.UserRepository;
import com.example.demo.utils.db.unit.ConverterUserDB;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class UserService {

    private final UserRepository userRepository;
    private final TodoService todoService;
    private final AlbumService albumService;
    private final PostService postService;

    public List<UserResponse> getAll (String name){
        List<UserDomain> users = Objects.isNull(name) ? userRepository.findAll() : userRepository.findByName(name);
        return users.stream().map(ConverterUserDB::convertUserDomainToResponse)
                .collect(Collectors.toList());
    }

    public UserResponse getById (String id){
        UserDomain user = userRepository.findById(id).orElseThrow();
        return ConverterUserDB.convertUserDomainToResponse(user);
    }

    public List<UserResponse> getByLatLngRange (Double minLat, Double maxLat, Double minLng, Double maxLng){
        List<UserDomain> users = userRepository.getUserByLatLngRange(minLat, maxLat, minLng, maxLng);
        return users.stream().map(ConverterUserDB::convertUserDomainToResponse)
                .collect(Collectors.toList());
    }
    //todo fix this \/
    public List<CompleteUserDomain> getDumbCompleteUser (){
        return userRepository.getCompleteUsers();
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
        user.setId(new ObjectId(id));
        user = userRepository.save(user);
        return ConverterUserDB.convertUserDomainToResponse(user);
    }

    public void delete (String id){
        getById(id);
        todoService.deleteByUserId(id);
        postService.findByUserId(id).forEach(post -> postService.delete(post.getId().toHexString()));
        albumService.findByUserId(id).forEach(album -> albumService.delete(album.getId().toHexString()));
        userRepository.deleteById(id);
    }

    public List<UserDomain> fullLoad(List<UserDomain> users){
        return userRepository.saveAll(users);
    }

    public void purgeDB(){
        userRepository.deleteAll();
    }

}

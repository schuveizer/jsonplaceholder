package com.example.demo.service.db;

import com.example.demo.model.domain.completeuser.CompleteUserDomain;
import com.example.demo.model.gateway.completeuser.CompleteUserGateway;
import com.example.demo.model.request.CompleteUserRequest;
import com.example.demo.model.response.CompleteUserResponse;
import com.example.demo.repository.CompleteUserRepository;
import com.example.demo.service.GatewayService;
import com.example.demo.utils.db.ConverterCompleteUserDB;
import com.example.demo.utils.db.ConverterCompleteUserGateway;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class CompleteUserService {

    private final CompleteUserRepository completeUserRepository;
    private final GatewayService gatewayService;

    public List<CompleteUserResponse> getAll(){
        List<CompleteUserDomain> users = completeUserRepository.findAll();
        return users.stream().map(ConverterCompleteUserDB::convertCompleteUserDomainToResponse)
                .collect(Collectors.toList());
    }

    public CompleteUserResponse getById (String id){
        CompleteUserDomain user = completeUserRepository.findById(id).orElseThrow();
        return ConverterCompleteUserDB.convertCompleteUserDomainToResponse(user);
    }

    public CompleteUserResponse create (CompleteUserRequest request){
        CompleteUserDomain user = ConverterCompleteUserDB.convertCompleteUserRequestToDomain(request);
        user = completeUserRepository.insert(user);
        return ConverterCompleteUserDB.convertCompleteUserDomainToResponse(user);
    }

    public CompleteUserResponse update (CompleteUserRequest request, String id){
        getById(id);
        CompleteUserDomain user = ConverterCompleteUserDB.convertCompleteUserRequestToDomain(request);
        user.setId(new ObjectId(id));
        user = completeUserRepository.save(user);
        return ConverterCompleteUserDB.convertCompleteUserDomainToResponse(user);
    }

    public void delete (String id){
        getById(id);
        completeUserRepository.deleteById(id);
    }

    public void fullLoad (){
        purgeDB();
        List<CompleteUserGateway> users = gatewayService.getCompleteUser();
        List<CompleteUserDomain> convertedUsers = users.stream()
                .map(ConverterCompleteUserGateway::convertCompleteUserGatewayToDomain)
                .collect(Collectors.toList());
        completeUserRepository.saveAll(convertedUsers);
    }

    public void purgeDB (){
        completeUserRepository.deleteAll();
    }

}

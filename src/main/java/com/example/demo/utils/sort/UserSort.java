package com.example.demo.utils.sort;

import com.example.demo.model.domain.unit.user.UserDomain;
import com.example.demo.model.gateway.user.UserGateway;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component

public class UserSort {
    public static List<UserDomain> sortDomain(List<UserDomain> users){
        return users.stream().sorted((user1, user2) -> {
            if (user1.getName().compareTo(user2.getName()) != 0)
                return user1.getName().compareTo(user2.getName());

            if (user1.getUsername().compareTo(user2.getUsername()) != 0)
                return user1.getUsername().compareTo(user2.getUsername());

            return user1.getEmail().compareTo(user2.getEmail());
        }).collect(Collectors.toList());
    }

    public static List<UserGateway> sortGateway(List<UserGateway> users){
        return users.stream().sorted((user1, user2) -> {
            if (user1.getName().compareTo(user2.getName()) != 0)
                return user1.getName().compareTo(user2.getName());

            if (user1.getUsername().compareTo(user2.getUsername()) != 0)
                return user1.getUsername().compareTo(user2.getUsername());

            return user1.getEmail().compareTo(user2.getEmail());
        }).collect(Collectors.toList());
    }
}

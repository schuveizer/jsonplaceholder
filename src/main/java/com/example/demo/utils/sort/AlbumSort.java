package com.example.demo.utils.sort;

import com.example.demo.model.domain.unit.AlbumDomain;
import com.example.demo.model.gateway.AlbumGateway;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component

public class AlbumSort {

    public static List<AlbumDomain> sortDomain(List<AlbumDomain> albums){
        return albums.stream().sorted(Comparator.comparing(AlbumDomain::getTitle)
        ).collect(Collectors.toList());
    }

    public static List<AlbumGateway> sortGateway(List<AlbumGateway> albums){
        return albums.stream().sorted(Comparator.comparing(AlbumGateway::getTitle)
        ).collect(Collectors.toList());
    }
}

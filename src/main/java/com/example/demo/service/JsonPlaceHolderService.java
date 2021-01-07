package com.example.demo.service;

import com.example.demo.repository.JsonPlaceHolderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class JsonPlaceHolderService {

    private final JsonPlaceHolderRepository jsonPlaceHolderRepository;

}

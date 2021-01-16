package com.example.demo.controller.db.unit;


import com.example.demo.service.db.LoadService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping ("/db/load")

public class LoadController {

    private final LoadService loadService;

    @PostMapping
    public void fullLoad(){
        loadService.fullLoad();
    }

    @DeleteMapping
    public void purgeDB (){
        loadService.purgeDB();
    }

    @PostMapping ("/strict")
    public void fullStrictLoad(){
        loadService.strictFullLoad();
    }
}

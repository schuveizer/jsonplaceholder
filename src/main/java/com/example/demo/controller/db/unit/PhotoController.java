package com.example.demo.controller.db;

import com.example.demo.model.request.PhotoRequest;
import com.example.demo.model.response.PhotoResponse;
import com.example.demo.service.db.PhotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping ("/db/photo")

public class PhotoController {

    private final PhotoService photoService;

    @GetMapping
    public List<PhotoResponse> getAll(){
        return photoService.getAll();
    }

    @GetMapping ("/{id}")
    public PhotoResponse getById (@PathVariable String id){
        return photoService.getById(id);
    }

    @PostMapping
    public PhotoResponse create (@Valid @RequestBody PhotoRequest request){
        return photoService.create(request);
    }

    @PutMapping ("/{id}")
    public PhotoResponse update (@RequestBody PhotoRequest request, @PathVariable String id){
        return photoService.update(request, id);
    }

    @DeleteMapping ("/{id}")
    public void delete (@PathVariable String id){
        photoService.delete(id);
    }
}

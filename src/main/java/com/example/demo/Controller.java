package com.example.demo;

import com.example.demo.dto.InsertDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/")
public class Controller {
    private final UserService service;
    @PostMapping("/insert")
    public User insert(InsertDto insertDto){
        return service.isnert(insertDto);
    }
    @GetMapping("/find/{id}")
    public User find(@PathVariable Integer id){
        return service.findById(id);
    }
}

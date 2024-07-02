package com.example.demo;

import com.example.demo.dto.InsertDto;

public interface UserService {
    User isnert(InsertDto insertDto);
    User findById(Integer id);
}

package com.example.demo.service;

import com.example.demo.domain.User;
import com.example.demo.dto.InsertDto;

public interface UserService {
    User isnert(InsertDto insertDto);
    User findById(Integer id);
}

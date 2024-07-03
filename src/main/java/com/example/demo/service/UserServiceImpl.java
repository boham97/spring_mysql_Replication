package com.example.demo.service;

import com.example.demo.repository.UserRepository;
import com.example.demo.domain.User;
import com.example.demo.dto.InsertDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    @Transactional
    @Override
    public User isnert(InsertDto insertDto) {
        User user = User.toEntity(insertDto);
        repository.save(user);
        return user;
    }
    @Transactional(readOnly = true)
    @Override
    public User findById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new IllegalStateException("user not found!"));
    }
}

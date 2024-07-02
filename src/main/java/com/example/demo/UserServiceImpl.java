package com.example.demo;

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
        User user = User.builder()
                .username(insertDto.getUsername())
                .email(insertDto.getEmail())
                .build();
        repository.save(user);
        return user;
    }
    @Transactional(readOnly = true)
    @Override
    public User findById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new IllegalStateException("user not found!"));
    }
}

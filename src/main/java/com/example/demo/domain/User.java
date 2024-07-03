package com.example.demo.domain;

import com.example.demo.dto.InsertDto;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
@Data
@Table(name = "Users")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String email;
    private Timestamp created_at;
    public static User toEntity(InsertDto insertDto){
        User user = new User();
        user.setUsername(insertDto.getUsername());
        user.setEmail(insertDto.getEmail());
        return user;
    }
}

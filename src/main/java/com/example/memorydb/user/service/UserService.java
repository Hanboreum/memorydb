package com.example.memorydb.user.service;

import com.example.memorydb.user.db.UserRepository;
import com.example.memorydb.user.model.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
@RequiredArgsConstructor //@Autowired대신

public class UserService {

    private final UserRepository userRepository; //스프링이 자동으로 찾아줘야,
    public UserEntity save(UserEntity user){
        //save
        return userRepository.save(user);
    }
    @GetMapping("/all")
    public List<UserEntity> findAll(){
        return userRepository.findAll();
    } //find all
}

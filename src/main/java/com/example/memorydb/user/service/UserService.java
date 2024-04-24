package com.example.memorydb.user.service;

import com.example.memorydb.user.db.UserRepository;
import com.example.memorydb.user.model.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor //@Autowired대신

public class UserService {

    private final UserRepository userRepository; //스프링이 자동으로 찾아줘야,
    public UserEntity save(UserEntity user){
        //save
        return userRepository.save(user);
    }

    public List<UserEntity> findAll(){
        return userRepository.findAll();
    } //find all

    public void delete(UserEntity id){
        userRepository.delete( id);
    }
    public Optional<UserEntity> findById(Long id){
        return userRepository.findById(id);
    }

    public List<UserEntity>filterScore(int score){
       return userRepository.findAllByScoreGreaterThanEqual(score);
    }
    public List<UserEntity> filterScore( int min, int max){
        return userRepository.findByScoreGreaterThanEqualAndScoreLessThanEqual(min, max);
    }
}

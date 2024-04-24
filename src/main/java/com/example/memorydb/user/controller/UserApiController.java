package com.example.memorydb.user.controller;

import com.example.memorydb.user.model.UserEntity;
import com.example.memorydb.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //http요청 들어오는 내용을 처맇고, 응답을 처리하는 영역이다.
@RequestMapping("/api/user")
@RequiredArgsConstructor //생성자 ㅁ메서드로 채워줌. 유저 서비스를 스프링으로부터 주입 받을 수 있음
public class UserApiController {

    private final UserService userService;
    @PutMapping("")
    public UserEntity create(@RequestBody UserEntity userEntity){
        return userService.save(userEntity);
    }//create, update

    @GetMapping("/all")
    public List<UserEntity> findAll(){
        return userService.findAll();
    }//findall

    @DeleteMapping("/id/{id}")
    public void delete(@PathVariable UserEntity id){ //Long -> UserEn
         userService.delete(id);
    } //delete
    @GetMapping("/id/{id}")
    public UserEntity findOne(@PathVariable long id){
        var response =  userService.findById(id);
        return response.get();
    }
    @GetMapping("/score")//http://localhost:8080/api/user/score?score=70
    public List<UserEntity> filterScore(@RequestParam int score){
            return  userService.filterScore(score);
    }
    @GetMapping("/min_max") //http://localhost:8080/api/user/min_max?min=84&max=100
    public List<UserEntity> filterScore( @RequestParam int min, @RequestParam int max){
        return userService.filterScore(min, max);
    }
    @GetMapping("/name")
    public List<UserEntity> filterName(@RequestParam String name){
        return userService.filterName(name);
    }
}

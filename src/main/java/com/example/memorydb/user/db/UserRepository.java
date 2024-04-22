package com.example.memorydb.user.db;

import com.example.memorydb.db.SimpleDataRepository;
import com.example.memorydb.user.model.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//각각의 데이터는 long타입의 아이디를 갖는다.
//각각 저장되는 타입은 userentity라는 내용으로 저장된다.
@Service
public class UserRepository extends SimpleDataRepository<UserEntity, Long> {

    //해당 점수보다 높은 사용자
  public List<UserEntity> findUsersWithScoreAbove(int score){
      return this.findAll().stream() //전체 리스트에 stream으로 필터를 건다.
              .filter(
                      it ->{
                          return it.getScore() >= score;
                      }//db에 들어있는 스코어중 매개변수 스코어보다 큰 값을을 리스트로 반환
              ).collect(Collectors.toList());
  }
}

package com.example.memorydb.user.db;

import com.example.memorydb.user.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

//어떤 entity를 다룰 것인지 제네릭으로 표시, 각각의 데이터는 long타입의 아이디를 갖는다.
//각각 저장되는 타입은 userentity라는 내용으로 저장된다.

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    //해당 점수보다 높은 사용자
    // select * from user where score >= []
    //findAll = 모두 찾겠다 /By 뒤로는 where절/ Scores = score 필드에서 / GreaterThanEqual 크거나 같은 >=
     List<UserEntity> findAllByScoreGreaterThanEqual(int score);

    //select * from user where score <= [] and score >= [] , 최대점수와 최소 점수 사이
    //GreaterThan 은 int min, LessThan은 int max에 매핑
     List<UserEntity> findByScoreGreaterThanEqualAndScoreLessThanEqual(int min, int max);


}

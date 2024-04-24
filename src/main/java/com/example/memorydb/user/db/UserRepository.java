package com.example.memorydb.user.db;

import com.example.memorydb.db.SimpleDataRepository;
import com.example.memorydb.user.model.UserEntity;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//어떤 entity를 다룰 것인지 제네릭으로 표시, 각각의 데이터는 long타입의 아이디를 갖는다.
//각각 저장되는 타입은 userentity라는 내용으로 저장된다.

interface UserRepository extends JpaRepository<UserEntity, Long> {

    //해당 점수보다 높은 사용자

}

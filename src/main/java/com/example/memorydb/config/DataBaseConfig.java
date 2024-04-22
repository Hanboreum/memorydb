package com.example.memorydb.config;

import com.example.memorydb.user.db.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
@Configuration //설정
//스프링이 실행될 때 configuration이라는 어노테이션을 찾아 특정내용들을
//spring context라는 영역에 new생성자를 통해 객체를 만들어 둔다

public class DataBaseConfig {

    @Bean//bean으로 만들어져 스프링에 의해 관리
    public UserRepository userRepository(){
        return new UserRepository();
    }
}
@RequiredArgsConstructor 를 쓰기에 필요 없음
@Autowired 사용시 필요
외부 클래스들은  return new UserRepository(); new 생성자
내부 클래스는 @Service
*/

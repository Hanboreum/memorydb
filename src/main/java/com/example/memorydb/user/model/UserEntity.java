package com.example.memorydb.user.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.math.BigDecimal;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "user") //db와 매핑. user테이블과 연결
public class UserEntity {

    @Id //pk에 해당하는
    @GeneratedValue(strategy = GenerationType.IDENTITY) //pk값이 어떻게 생성, 관리 되는지(idnetity = db 책임)
    private Long id;
    private String name;
    private int score;
}

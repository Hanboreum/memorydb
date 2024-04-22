package com.example.memorydb.book.db.entity;

import com.example.memorydb.entity.Entity;
import lombok.*;

import java.math.BigDecimal;
//책의 속성
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookEntity extends Entity {

    private String name;
    private String category;
    private BigDecimal amount;
}

package com.example.memorydb.entity;
//구현
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Entity implements PrimaryKey{

    private Long ig;
}

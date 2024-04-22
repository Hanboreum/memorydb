package com.example.memorydb.entity;
//구현
import lombok.*;


public abstract class Entity implements PrimaryKey{

    @Getter
    @Setter
    private Long ig;
}

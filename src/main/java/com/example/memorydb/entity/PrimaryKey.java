package com.example.memorydb.entity;
//ID 지정, id는 고유한 값이다.
public interface PrimaryKey {

    void setId(Long id);
    Long getId();
}

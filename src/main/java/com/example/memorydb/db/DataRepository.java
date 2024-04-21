package com.example.memorydb.db;

import java.util.List;
import java.util.Optional;

public interface DataRepository <T, ID> extends Repository<T, ID> {
    T save(T data); //create, update (id 찾아보고 없으면 save 있으면 update)

    Optional<T> findById (ID id); //read
    List<T> findAll();

    //delete
    void delete (ID id);
}

package com.example.memorydb.db;

import com.example.memorydb.entity.Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

//얘를 구현 받으면 구현 해도 되고, 안해도 됨
abstract public class SimpleDataRepository <T extends Entity, ID extends Long> implements DataRepository<T, ID>{
    //extends entity 통해 상속받은 것들에게 ?
    //generic 타입은 반드시 entity룰 상속받은 것만 들어올 수 있음


    private List<T> dataList = new ArrayList<T>();
    private static long index = 0;

    //create,update

    @Override
    public T save(T data) {

        if(Objects.isNull(data)){//데이터 없으ㅁㄴ 예외
            throw new RuntimeException("Data is null");
        }

        //id가 이미 있는가
        var prevData = dataList.stream()
                .filter(it ->{
                   return it.getId().equals(data.getId());
                })
                .findFirst();

        if(prevData.isPresent()){ //있는 경우
            dataList.remove(prevData);//삭제
            dataList.add(data);// 삽입
        }else{ //id 없는 경우
            index ++;
            data.setId(index);
            dataList.add(data);
        }
        return  data;
    }

    //read
    public Optional <T> findById( ID id){
        return dataList.stream()
                .filter(it -> {
                    return ( it.getId().equals(id));
                })
                .findFirst();
    }
}

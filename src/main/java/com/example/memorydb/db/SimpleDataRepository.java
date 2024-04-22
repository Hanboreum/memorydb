package com.example.memorydb.db;

import com.example.memorydb.entity.Entity;

import java.util.*;
import java.util.stream.Collectors;
// 구현체
//얘를 구현 받으면 구현 해도 되고, 안해도 됨
abstract public class SimpleDataRepository <T extends Entity, ID extends Long> implements DataRepository<T, ID>{
    //extends entity 통해 상속받은 것들에게 ?
    //generic 타입은 반드시 entity룰 상속받은 것만 들어올 수 있음


    private List<T> dataList = new ArrayList<T>(); //userentity가 들어간다.
    private static long index = 0;

    private Comparator<T> sort = new Comparator<T>() {
        @Override
        public int compare(T o1, T o2) {
            return Long.compare( o1.getId(), o2.getId());
        }
    };
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
    @Override
    public Optional <T> findById( ID id){ //데이터가 있을 수도, 없을 수도 있기 때문에 Optional
        return dataList.stream()
                .filter(it -> {
                    return ( it.getId().equals(id));
                })
                .findFirst();
    }

    @Override
    public List<T> findAll() {
        return dataList.stream()
                .sorted(sort)
                .collect(Collectors.toList());
    }
    //delete

    @Override
    public void delete(ID id) {
        var deleteEntity = dataList.stream()
                .filter(it -> {
                    return ( it.getId().equals(id));
                })
                .findFirst();

        if(deleteEntity.isPresent()){
            dataList.remove(deleteEntity);
        }
    }
}

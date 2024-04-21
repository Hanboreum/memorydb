package com.example.memorydb.db;

import java.util.ArrayList;
import java.util.List;

//얘를 구현 받으면 구현 해도 되고, 안해도 됨
abstract public class SimpleDataRepository <T, ID> implements DataRepository<T, ID>{

    private List<T> dataLIst = new ArrayList<T>();
    private static long index = 0;
}

package com.example.memorydb.book.db.repository;

import com.example.memorydb.book.db.entity.BookEntity;
import com.example.memorydb.db.SimpleDataRepository;
import org.springframework.stereotype.Service;

@Service //bin으로 스프링한테 등록 요청
public class BookRepository extends SimpleDataRepository<BookEntity, Long> {
    //id는 long타입
}


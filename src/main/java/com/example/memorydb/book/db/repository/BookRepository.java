package com.example.memorydb.book.db.repository;

import com.example.memorydb.book.db.entity.BookEntity;
import com.example.memorydb.db.SimpleDataRepository;
import org.springframework.stereotype.Service;

@Service //bin으로 스프링한테 등록 요청
//BookRepository엔 bookentity에 대한 클래스 내용을 가진 정보가 담김 = 저장소
public class BookRepository extends SimpleDataRepository<BookEntity, Long> {
    //id는 long타입
}


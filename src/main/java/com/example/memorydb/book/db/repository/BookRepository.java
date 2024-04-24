package com.example.memorydb.book.db.repository;

import com.example.memorydb.book.db.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;


//BookRepository엔 bookentity에 대한 클래스 내용을 가진 정보가 담김 = 저장소
public interface BookRepository extends JpaRepository<BookEntity, Long> {
    //id는 long타입
}


package com.example.memorydb.book.service;

import com.example.memorydb.book.db.entity.BookEntity;
import com.example.memorydb.book.db.repository.BookRepository;
import com.example.memorydb.user.model.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    //create. update
    public BookEntity create(BookEntity book) {
        return bookRepository.save(book);
    }

    //all
    public List<BookEntity> findAll() {
        return bookRepository.findAll();
    }

    //delete
    public void delete(BookEntity id) {
         bookRepository.delete(id);
    }
    //findone
    public Optional<BookEntity> findById(long id){
        return bookRepository.findById(id);
    }

}


//특정 카테고리 출ㄹ력

/*
버전 1.
@Service //@Service를 통해 스프링 컨텍스트에 만들어져 들어갈 때 해당 컨텍스트에 book repo를 찾아 여기 생성자에 주입한다.

private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository){
        this.bookRepository =bookRepository;
    } //bookservice 생성시 이 생성자 메서드로 생성함.
    //이때 bookservice에 주입해주는 것이 스프링 역할
    //BookService를 생성자 메소드로 작성하게 되면 스프링은 bin영역에서 찾는다 .
----
verson 2.
@Service
 @Autowired
    private BookRepository bookRepository;
   생성자는 bin으로 생성하고 주입을 해주게 된다.
   또는 생성자로 우리가 받게 되면 나중에 테스트 코드라든지 뭔가 할 때 우리가 원하는 book repo
   를 ㅇ만들어서 넣을 수 있다.
    @RequiredArgsConstructor이거ㅏ 쓰면 코드 간결
 */
package com.example.memorydb.book.controller;

import com.example.memorydb.book.db.entity.BookEntity;
import com.example.memorydb.book.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/book")
@RequiredArgsConstructor
public class BookApiController {
    private final BookService bookService;

   @GetMapping("/all")
    public List<BookEntity> findAll(){
       return bookService.findAll();
   }

   @PostMapping("")
   public BookEntity create( @RequestBody BookEntity book){
       return bookService.create(book);
   }
   @DeleteMapping("/id/{id}")
    public void delete( @PathVariable BookEntity id){
       bookService.delete(id);
   }
   @GetMapping("/id/{id}")
    public Optional<BookEntity> findOne(@PathVariable long id){
       var response = bookService.findById(id);
       return response;
   }
   @GetMapping("/min_max") //http://localhost:8080/api/book/min_max?min=20000&max=35000
    public List<BookEntity> filterAmount(@RequestParam int min, @RequestParam int max){
       return bookService.filterAmount(min, max);
   }
   @GetMapping("/category")
    public List<BookEntity> filterCategory(@RequestParam String category){
       return bookService.filterCategory(category);
   }

}

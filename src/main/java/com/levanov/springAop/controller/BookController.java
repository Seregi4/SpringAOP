package com.levanov.springAop.controller;

import com.levanov.springAop.entity.Book;
import com.levanov.springAop.service.BookService;
import com.levanov.springAop.util.CustomResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
//@Tag(name = "Book controller", description = "get and post ")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public CustomResponse<Book> getAll(){
        return bookService.getAll();
    }

    @GetMapping("/books/{title}")
    public CustomResponse<Book> getBoolByTitle(@PathVariable("title")  String title){
        return bookService.getBookByTitle(title);
    }

    @PostMapping("/books")
    public CustomResponse<Book> addBook(@RequestBody Book book){
        return bookService.addBook(book);
    }
}


package com.example.booklibrary;
import com.example.booklibrary.repository.BookDB;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import service.BookService;

@SpringBootApplication
public class BooklibraryApplication {

    public static void main(String[] args) {
       SpringApplication.run(BooklibraryApplication.class, args);

            BookDB repo = new BookDB();
            BookService bookService = new BookService(repo);

            System.out.println(bookService.getBookById("2"));
            System.out.println(bookService.getAllBooks());









    }






}

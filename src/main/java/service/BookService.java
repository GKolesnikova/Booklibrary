package service;
import com.example.booklibrary.model.Book;
import com.example.booklibrary.repository.BookDB;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class BookService {

    private BookDB books;

    public BookService(BookDB books) {
        this.books = books;
    }

    public Book getBookById(String id) {
        return books.getBookById(id);
    }

    public List<com.example.booklibrary.model.Book> getAllBooks() {
        return books.getAllBooks();
    }

}








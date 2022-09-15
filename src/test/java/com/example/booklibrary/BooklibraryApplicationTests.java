package com.example.booklibrary;
import com.example.booklibrary.model.Book;
import com.example.booklibrary.repository.BookDB;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import service.BookService;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@SpringBootTest
class BooklibraryApplicationTests {

    private BookDB bookDbRepo;
    BookDB booksRepo = mock(BookDB.class);
    BookService service = new BookService(bookDbRepo);
    

    @Test
    void getBookByIdWhenIsValid() {
        // GIVEN
        String id = "2";
        when(booksRepo.getBookById(id));

        // WHEN
        Book actual = service.getBookById(id);

        // THEN
        assertEquals(booksRepo.getBookById(id), actual);
    }


    @Test
     void  getAllBooksTest() {
        // GIVEN
        when(booksRepo.getAllBooks());

        // WHEN
        List<Book> actual = service.getAllBooks();

        // THEN
        assertEquals(booksRepo.getAllBooks(), actual);
        }








}

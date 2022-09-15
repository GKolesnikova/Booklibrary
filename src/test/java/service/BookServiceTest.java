package service;
import com.example.booklibrary.model.Book;
import com.example.booklibrary.repository.BookDB;
import com.example.booklibrary.service.BookService;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class BookServiceTest {



        private BookDB bookDbRepo = mock(BookDB.class);

        private BookService service = new BookService(bookDbRepo);




        @Test
        void getAllBooksTest() {
            // GIVEN
            List<Book> dummyBooks = List.of (
                    new Book("Java ist auch ein insel", "Christian Ullenboom", "1"),
                    new Book("Clean Code", "Robert C.Martin", "2")
            );
            when(service.getAllBooks()).thenReturn(dummyBooks);

            // WHEN
            List<Book> actual = service.getAllBooks();

            // THEN


            List<Book> exspected = List.of(
                    new Book("Java ist auch ein insel", "Christian Ullenboom", "1"),
                    new Book("Clean Code", "Robert C.Martin", "2")

            );
            assertEquals(exspected, actual);
        }




        @Test
        void getBookByIdWhenIdExist_returnBook() {
            // GIVEN

            Book dummyBook = new Book("Java ist auch ein insel", "Christian Ullenboom", "1");
            when(bookDbRepo.getBookById("1")).thenReturn(dummyBook);

            // WHEN
            Book actual = service.getBookById("1");

            // THEN

            Book expected = new Book("Java ist auch ein insel", "Christian Ullenboom", "1");
            assertEquals(expected, actual);
        }


       /* @Test
        void getBookByIdWhenIdDoesNotExist_returnBook() {
            // GIVEN
            when(bookDbRepo.getBookById("1")).thenReturn(null);

            // WHEN & THEN
            assertThrows(NoSuchElementException.class, () ->  service.getBookById("1"));
        }*/





}
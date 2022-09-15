package controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.BookService;


@RestController
@RequestMapping("/book")
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
        System.out.println(bookService.getAllBooks());
    }


    @GetMapping(path = "{name}")
    public String getBookById(@PathVariable String id) {
        return "Book of your choice is  " + bookService.getBookById(id);
    }












}

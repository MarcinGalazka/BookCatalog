package pl.marcingalazka.bookcatalog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pl.marcingalazka.bookcatalog.model.Book;
import pl.marcingalazka.bookcatalog.service.BookService;

@Controller
public class BookController {

   private final BookService bookService;

    @Autowired
    public BookController(@Qualifier("DBBookService") BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("book-list")
    public ModelAndView updateBookList(){
        ModelAndView modelAndView = new ModelAndView("book-list");
        modelAndView.addObject("books", bookService.getBooks());
        return modelAndView;
    }

    @GetMapping("book-detail")
    public ModelAndView seeBookDetails(@RequestParam ("bookId") Long bookId){
        ModelAndView modelAndView = new ModelAndView("book-detail");
        modelAndView.addObject("book",bookService.getBookById(bookId));
        return modelAndView;
    }

    @PostMapping("delete-book")
    public ModelAndView deleteBook(@ModelAttribute Book book){
        System.out.println("book: " + book);
        bookService.removeBook(book.getId());
        ModelAndView modelAndView = new ModelAndView("redirect:book-list");
        //wyświetla listę książek po usunięciu
        modelAndView.addObject("books",bookService.getBooks());
        return modelAndView;
    }

    @GetMapping("/")
    public ModelAndView redirectToBookList(){
        ModelAndView modelAndView = new ModelAndView("forward:book-list");
        return modelAndView;
    }

    @GetMapping("book-add")
    public ModelAndView addBook(){
        ModelAndView modelAndView = new ModelAndView("book-add");
        modelAndView.addObject("book", new Book());
        return modelAndView;
    }


}

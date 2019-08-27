package pl.marcingalazka.bookcatalog.service;

import pl.marcingalazka.bookcatalog.model.Book;

import java.util.List;

public interface BookService {
     List<Book> getBooks();
     Book getBookById(Long bookId);

    void removeBook(Long id);
    void addBook(Book book);
}

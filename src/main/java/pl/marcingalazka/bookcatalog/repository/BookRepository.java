package pl.marcingalazka.bookcatalog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.marcingalazka.bookcatalog.model.Book;

@Repository
//połączenie z bazą danych
public interface BookRepository extends JpaRepository<Book,Long> {
}

package pl.marcingalazka.bookcatalog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pl.marcingalazka.bookcatalog.model.Book;
import pl.marcingalazka.bookcatalog.repository.BookRepository;
import pl.marcingalazka.bookcatalog.service.BookService;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
class DBBookService implements BookService {

    private BookRepository bookRepository;

    @PostConstruct
    public void init() {
        //todo: create list of books

        //todo: put books into book table with bookRepository

        bookRepository.save(new Book(null,
                        "Python dla każdego. Podstawy programowania",
                        "45234523",
                        "Chcesz się nauczyć programować? Świetna decyzja! Wybierz język obiektowy, łatwy w użyciu, " +
                                "z przejrzystą składnią. Python będzie wprost doskonały! Rozwijany od ponad 20 lat, " +
                                "jest dojrzałym językiem, pozwalającym tworzyć zaawansowane aplikacje dla różnych " +
                                "systemów " +
                                "operacyjnych. Ponadto posiada system automatycznego zarządzania pamięcią, który " +
                                "zdejmuje " +
                                "z programisty obowiązek panowania nad tym skomplikowanym obszarem.",
                        2014, "Dawson Michael"
                )
        );

        bookRepository.save(new Book(null,
                "Czysty kod. Podręcznik dobrego programisty",
                "54325342",
                "Poznaj najlepsze metody tworzenia doskonałego kodu",
                2014, "Robert C. Martin"
        ));

        bookRepository.save(new Book(null,
                "Programista samouk. Profesjonalny przewodnik do samodzielnej nauki kodowania",
                "634565", "Nie wystarczy znajomość jednego języka programowania, aby zostać programistą. " +
                "W rzeczywistości trzeba opanować dość szeroki zakres pojęć i paradygmatów, a także zrozumieć " +
                "zagadnienia związane z algorytmami. Trzeba być na bieżąco z nowymi technologiami i narzędziami. " +
                "Należy również poznać i zacząć stosować dobre praktyki programistyczne i przyswoić sobie zasady " +
                "pracy w zespole. Przede wszystkim jednak priorytetem jest sama praktyka, ponieważ wielu programistów" +
                " " +
                "wciąż ma problem z pisaniem poprawnego kodu."
                ,
                2017,
                "Althoff Cory"));


        bookRepository.save(new Book(null,
                "Pragmatyczny programista. Od czeladnika do mistrza",
                "325465", "Od ambitnego do najlepszego - czyli jak stać się programistą wydajnym, dociekliwym i " +
                "gotowym do wszelkich zawodowych wyzwań!\n" +
                "Poznaj najlepsze praktyki i najczęstsze pułapki procesu wytwarzania oprogramowania\n" +
                "Naucz się pisać elastyczny, dynamiczny i łatwy w dostosowywaniu kod\n" +
                "Opanuj sprawdzone techniki efektywnego testowania oprogramowania", 2012, "Andrew Hunt"));


        bookRepository.save(new Book(null, "Praca z zastanym kodem. Najlepsze techniki", "147896", "Ta unikatowa " +
                "książka " +
                "zawiera wszystkie najpotrzebniejsze informacje, dotyczące doboru technik i sposobów wprowadzania " +
                "zmian w zastanym kodzie. Dzięki niej nie tylko nauczysz się pracować na starym kodzie, ale także stosować " +
                "testy automatyczne oraz przeprowadzać skuteczną refaktoryzację. Od teraz przerośnięte klasy i metody" +
                " nie będą stanowiły dla Ciebie żadnego problemu!", 2013, "Michael Feathers"));
    }


    @Autowired
    public DBBookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(Long bookId) {
        return bookRepository.getOne(bookId);
    }

    @Override
    public void removeBook(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public void addBook(Book book) {

    }

}

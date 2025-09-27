package xyz.sadiulhakim;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import xyz.sadiulhakim.item1.Author;
import xyz.sadiulhakim.item1.AuthorRepo;
import xyz.sadiulhakim.item1.Book;
import xyz.sadiulhakim.item1.BookRepo;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class Application implements CommandLineRunner {

    private final AuthorRepo authorRepo;
    private final BookRepo bookRepo;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        Book book1 = new Book(null, "title", "isbn");
        Book book2 = new Book(null, "title2", "isbn");

        Author auth1 = new Author(null,"Author1","Test",30, List.of(book1));
        Author auth2 = new Author(null,"Author2","Test",32,List.of(book2));

        auth1 = authorRepo.save(auth1);
        auth2 = authorRepo.save(auth2);

//        book1 = bookRepo.save(book1);
//        book2 = bookRepo.save(book2);
//
//        bookRepo.findById(book1.getId());
//        bookRepo.deleteById(book2.getId());
    }
}

package xyz.sadiulhakim;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class Application implements CommandLineRunner {

    private final AuthRepo authRepo;
    private final BookRepo bookRepo;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        //        Author bazlur = new Author();
//        bazlur.setAge(35);
//        bazlur.setName("A N M Bazlur");
//        bazlur.setGenre("Programming");
//
//        Book b1 = new Book();
//        b1.setTitle("Java Programming");
//        b1.setIsbn("001-BZ");
//
//        Book b2 = new Book();
//        b1.setTitle("Java Thread Programming");
//        b1.setIsbn("002-BZ");
//
//        bazlur.addBook(b1);
//        bazlur.addBook(b2);
//
//        authRepo.save(bazlur);
//----------------
//        Author author = authRepo.getReferenceById(1L);
//
//        var b1 = new Book();
//        b1.setTitle("Java Advanced Programming");
//        b1.setIsbn("003-BZ");
//        b1.setAuthor(author);
//
//        bookRepo.save(b1);
//
//        b1.setTitle("Java Thread Programming");
        //---------------------
//        Author author = authRepo.findById(1L).orElseThrow();
//        List<Book> books = author.getBooks();
//        author.removeBook(books.getLast());
        //-------------------
//        Author author = authRepo.findById(1L).orElseThrow();
//        List<Book> books = author.getBooks();
//        author.removeBook(books.getFirst());

        //------------------------------
//        Author author = authRepo.getReferenceById(1L);
//        List<Book> books = bookRepo.findAllByAuthor(author);
//        System.out.println(books);

//        Page<Book> allBooksOfAuthor = bookRepo.findAllBooksOfAuthor(1L, PageRequest.of(1, 2, Sort.by(Sort.Direction.ASC, "title")));
//        System.out.println(allBooksOfAuthor.getTotalPages());
//        System.out.println(allBooksOfAuthor.getNumber());
//        System.out.println(allBooksOfAuthor.getContent());
//        allBooksOfAuthor.getFirst().setIsbn("Not Available");
    }
}

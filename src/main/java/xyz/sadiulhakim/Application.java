package xyz.sadiulhakim;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

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
//        Author a1 = new Author();
//        a1.setName("a1");
//        a1.setAge(21);
//        a1.setGenre("G1");
//
////        Author a2 = new Author();
////        a2.setName("a2");
////        a2.setAge(21);
////        a2.setGenre("G2");
//
//        Book b1 = new Book();
//        b1.setTitle("b1");
//        b1.setIsbn("1");
//
//        Book b2 = new Book();
//        b2.setTitle("b2");
//        b2.setIsbn("2");
//
//        Book b3 = new Book();
//        b3.setTitle("b3");
//        b3.setIsbn("3");
//
//        Book b4 = new Book();
//        b4.setTitle("b4");
//        b4.setIsbn("4");
//
//        a1.addBook(b1);
//        a1.addBook(b2);
//        a1.addBook(b3);
//        a1.addBook(b4);
//
//        authRepo.save(a1);
//        authRepo.save(a2);
        //----------------------------------
        Author author = authRepo.findById(5L).orElseThrow();
        authRepo.delete(author);
    }
}

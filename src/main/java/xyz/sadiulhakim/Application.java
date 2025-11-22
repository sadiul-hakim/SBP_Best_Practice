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
//        var author1 = new Author();
//        author1.setName("Author1");
//        author1.setGenre("Nothing");
//        author1.setAge(35);
//
//        var author2 = new Author();
//        author2.setName("Author2");
//        author2.setGenre("Nothing");
//        author2.setAge(37);
//
//        var book1 = new Book();
//        book1.setTitle("Book1");
//        book1.setIsbn("Nothing");
//
//        var book2 = new Book();
//        book2.setTitle("Book2");
//        book2.setIsbn("Nothing");
//
//        var book3 = new Book();
//        book3.setTitle("Book3");
//        book3.setIsbn("Nothing");
//
//
//        author1.addBook(book1);
//        author2.addBook(book1);
//
//        author2.addBook(book2);
//        author1.addBook(book3);
//
//        // Note: You do not have to save books. Like bookRepo.save(book1);
//
//        authRepo.save(author1);
//        authRepo.save(author2);

        // -----------------------------

//        Author author1 = authRepo.findById(1L).orElseThrow();
//        Book book1 = bookRepo.findById(1L).orElseThrow();
//
//        // If we use List instead of set, Hibernate deletes all entities of the author from junction table then reinsert entities except the deleting one
//        author1.removeBook(book1);

        // ----------------------------------------

//        Author author1 = authRepo.findById(1L).orElseThrow();
//        var book1 = new Book();
//        book1.setTitle("Book1");
//        book1.setIsbn("Nothing");
//
//        author1.addBook(book1);
        //---------------------------
//        Author author1 = authRepo.findById(1L).orElseThrow();
//        var book1 = bookRepo.findById(1L).orElseThrow();
//
//        author1.addBook(book1);

        // -----------------------------

//        var book1 = bookRepo.findById(1L).orElseThrow();
//        var author3 = new Author();
//        author3.setName("Author3");
//        author3.setGenre("Nothing");
//        author3.setAge(35);
//
//        var author4 = new Author();
//        author4.setName("Author4");
//        author4.setGenre("Nothing");
//        author4.setAge(35);
//
//        author3.addBook(book1);
//        author4.addBook(book1);
//
//        authRepo.save(author3);
//        authRepo.save(author4);
        //-----------------------------------------
        var book1 = bookRepo.findById(1L).orElseThrow();
        System.out.println(book1.getAuthors());
    }
}

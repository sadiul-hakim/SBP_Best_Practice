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
        Author author = authRepo.findById(1L).orElseThrow();
        Author clonedAuthor = new Author(author, true);
        clonedAuthor.setAge(54);
        clonedAuthor.setName("Farell Tliop");

        authRepo.save(clonedAuthor);
    }
}

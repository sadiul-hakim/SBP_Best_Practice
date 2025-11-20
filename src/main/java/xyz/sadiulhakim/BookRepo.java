package xyz.sadiulhakim;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BookRepo extends JpaRepository<Book, Long> {

    List<Book> findAllByAuthor(Author author);

    @Transactional(readOnly = true)
    @Query("select b from Book b where b.author.id=:id")
    List<Book> findAllBooksOfAuthor(@Param("id") Long id);
}
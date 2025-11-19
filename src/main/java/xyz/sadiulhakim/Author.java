package xyz.sadiulhakim;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.*;

@Setter
@Getter
@Entity
public class Author implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String genre;
    private int age;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Book> books = new ArrayList<>();

    public Author() {
    }

    public Author(Author author, boolean cloneChildren) {
        this.genre = author.getGenre();

        if (!cloneChildren) {
            // associate books
            books.addAll(author.getBooks()); // Even though I did not associate the author with books it still works
        } else {
            // clone each book
            for (Book book : author.getBooks()) {
                addBook(new Book(book));
            }
        }
    }

    public void addBook(Book book) {
        this.books.add(book);
//        book.setAuthor(this);
    }

    public void removeBook(Book book) {
//        book.setAuthor(null);
        this.books.remove(book);
    }

    public void removeBooks() {
        Iterator<Book> iterator = this.books.iterator();

        while (iterator.hasNext()) {
            Book book = iterator.next();

//            book.setAuthor(null);
            iterator.remove();
        }
    }

    @Override
    public String toString() {
        return "Author{" + "id=" + id + ", name=" + name
                + ", genre=" + genre + ", age=" + age + '}';
    }
}

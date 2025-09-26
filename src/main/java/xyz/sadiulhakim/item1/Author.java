package xyz.sadiulhakim.item1;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Author implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String genre;
    private int age;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "author")
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        this.books.add(book);
        book.setAuthor(this);
    }

    public void removeBook(Book book) {
        book.setAuthor(null);
        this.books.remove(book);
    }

    /// The key reason you **shouldn’t just replace the `books` list with a new empty list**
    /// (e.g. `this.books = new ArrayList<>()`) in `removeBooks()` is because of **JPA/Hibernate entity relationship management**.
    /// ### 1. `books` is a **managed collection**
    /// * When Hibernate loads an `Author`, it creates and manages the `books` collection internally (usually a proxy like `PersistentBag` or `PersistentList`).
    /// * If you replace it with a **new `ArrayList`**, Hibernate no longer tracks the changes to the original collection.
    /// * That means orphan removal (the `orphanRemoval = true`) might not work properly, and the database won’t get the correct `DELETE` statements for the orphaned `Book` rows.
    /// ---
    /// ### 2. Orphan removal requires `book.setAuthor(null)`
    /// * By calling `book.setAuthor(null)` inside the loop, you’re breaking the association from the **child’s side** (the owning side in this `@ManyToOne` relationship).
    /// * This ensures Hibernate knows each `Book` is now orphaned and should be deleted.
    /// If you just `this.books = new ArrayList<>()`, the old `Book`s would still have `author_id` pointing to this `Author` in the database, leaving dangling rows.
    ///  ---
    /// ### 3. Iterator approach = proper dirty checking
    /// * The `iterator.remove()` approach updates the **same managed collection** Hibernate is tracking.
    /// * This way, Hibernate sees that each `Book` has been removed from the relationship, and combined with `orphanRemoval = true`, it issues the appropriate SQL `DELETE`.
    public void removeBooks() {
        Iterator<Book> iterator = this.books.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            book.setAuthor(null);
            iterator.remove();
        }
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                ", age=" + age +
                '}';
    }
}

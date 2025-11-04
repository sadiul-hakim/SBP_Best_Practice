package xyz.sadiulhakim;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(
        name = "author_two",
        indexes = {
                @Index(
                        name = "index_name_genre",
                        columnList = "name, genre",
                        unique = true
                )
        }
)
public class AuthorTwo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "genre",nullable = false)
    private String genre;
    private int age;

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        return id != null && id.equals(((AuthorTwo) obj).id);
    }

    @Override
    public int hashCode() {
        return 2021;
    }

    @Override
    public String toString() {
        return "Author{" + "id=" + id + ", name=" + name
                + ", genre=" + genre + ", age=" + age + '}';
    }
}

package lena.library.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@Table(name = "data_genre.books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;

    @Column(name = "writtenYear")
    private Integer writtenYear;

    @Column(name = "description")
    private String description;

    @ManyToMany(mappedBy = "data_genre.authors_books")
    private Set<Author> authors;

    @ManyToMany(mappedBy = "data_genre.genres_books")
    private Set<Genre> genres;

    @Column(name = "readed")
    private boolean readed;  //прочитано ли, по дефолту НЕТ

    public boolean isReaded() {
        return readed;
    }

    public Book(Book book) {
        this(book.getId(), book.getName(), book.getDescription(), book.getWrittenYear(), book.isReaded());
    }

    public Book(Integer id, String name, String description, Integer writtenYear, boolean readed) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.writtenYear = writtenYear;
        this.readed = readed;
    }

    public boolean isNew() {
        return this.id == null;
    }

}

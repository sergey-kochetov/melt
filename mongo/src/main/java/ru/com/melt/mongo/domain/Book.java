package ru.com.melt.mongo.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;

@Document
@Data
@EqualsAndHashCode(of = "id")
public class Book {
    @Id
    private String id;
    private String name;
    private String description;
    private String content;
    private Genre genre;
    private Set<Author> authors = new HashSet<>();
    private Set<Comment> comments = new HashSet<>();

    public void addAuthor(@NonNull Author author) {
        authors.add(author);
    }

    public void addComment(@NonNull Comment comment) {
        comments.add(comment);
    }
}

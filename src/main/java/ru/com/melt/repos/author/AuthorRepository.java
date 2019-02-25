package ru.com.melt.repos.author;

import ru.com.melt.domain.Author;

import java.util.List;

public interface AuthorRepository {

    Long count();

    Author getById(Long id);

    List<Author> getAll();

    void deleteById(Long id);

    void insert(Author author);
}

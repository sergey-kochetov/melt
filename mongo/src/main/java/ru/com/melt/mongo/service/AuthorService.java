package ru.com.melt.mongo.service;

import ru.com.melt.mongo.domain.Author;

import java.util.List;

public interface AuthorService {
    long count();

    Author getById(String id);

    List<Author> getAllAuthor();

    void insert(String firstName, String secondName);

    void deleteById(String id);
}

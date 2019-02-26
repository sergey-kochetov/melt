package ru.com.melt.mongo.service;

import ru.com.melt.mongo.domain.Book;

import java.util.List;

public interface BookService {
    long count();

    Book getById(String id);

    List<Book> getAllBook();

    void insert(String name, String description, String content,
                String firstName, String secondName,
                String genreName, String comment);

    void deleteById(String id);
}

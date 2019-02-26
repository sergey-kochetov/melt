package ru.com.melt.mongo.service;

import ru.com.melt.mongo.domain.Genre;

import java.util.List;

public interface GenreService {
    long count();

    Genre getById(String id);

    List<Genre> getAllGenre();

    void insert(String idBook, String genreName);

    void deleteById(String id);
}

package ru.com.melt.mongo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.com.melt.mongo.domain.Book;
import ru.com.melt.mongo.domain.Genre;
import ru.com.melt.mongo.repository.BookRepository;
import ru.com.melt.mongo.repository.GenreRepository;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public long count() {
        return genreRepository.count();
    }

    @Override
    public Genre getById(String id) {
        return genreRepository.findById(id).get();
    }

    @Override
    public List<Genre> getAllGenre() {
        return genreRepository.findAll();
    }

    @Override
    public void insert(String idBook, String genreName) {
        Genre genre = new Genre();
        genre.setGenre(genreName);

        Book book = bookRepository.findById(idBook).get();
        book.setGenre(genre);

        genreRepository.save(genre);
        bookRepository.save(book);
    }

    @Override
    public void deleteById(String id) {
        genreRepository.deleteById(id);
    }
}

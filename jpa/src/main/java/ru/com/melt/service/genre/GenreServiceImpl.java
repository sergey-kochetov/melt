package ru.com.melt.service.genre;

import org.springframework.stereotype.Service;
import ru.com.melt.domain.Book;
import ru.com.melt.domain.Genre;
import ru.com.melt.repos.BookRepositoryJdbc;
import ru.com.melt.repos.GenreRepositoryJdbc;

import java.util.List;
import java.util.Set;

@Service
public class GenreServiceImpl implements GenreService {

    private final GenreRepositoryJdbc genreRepositoryJdbc;
    private final BookRepositoryJdbc bookRepositoryJdbc;

    public GenreServiceImpl(GenreRepositoryJdbc genreRepositoryJdbc, BookRepositoryJdbc bookRepositoryJdbc) {
        this.genreRepositoryJdbc = genreRepositoryJdbc;
        this.bookRepositoryJdbc = bookRepositoryJdbc;
    }

    @Override
    public void insert(long idBook, String genreName) {
        Book book = bookRepositoryJdbc.getById(idBook);

        Genre genre = new Genre();
        genre.setGenre(genreName);
        genre.setBook(book);

        Set<Genre> genres = book.getGenres();
        genres.add(genre);

        bookRepositoryJdbc.insert(book);
        genreRepositoryJdbc.insert(genre);
    }

    @Override
    public Long count() {
        return genreRepositoryJdbc.count();
    }

    @Override
    public Genre getById(long id) {
        return genreRepositoryJdbc.getById(id);
    }

    @Override
    public List<Genre> getAll() {
        return genreRepositoryJdbc.getAll();
    }

    @Override
    public void deleteById(long id) {
        genreRepositoryJdbc.deleteById(id);
    }
}

package ru.com.melt.service.book;

import lombok.NonNull;
import org.springframework.stereotype.Service;
import ru.com.melt.domain.Author;
import ru.com.melt.domain.Book;
import ru.com.melt.domain.Comment;
import ru.com.melt.domain.Genre;
import ru.com.melt.repos.BookRepositoryJdbc;
import ru.com.melt.service.EntityService;

import java.util.List;
import java.util.Set;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepositoryJdbc bookRepository;

    public BookServiceImpl(BookRepositoryJdbc bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Long count() {
        return bookRepository.count();
    }

    @Override
    public Book getById(long id) {
        return bookRepository.getById(id);
    }

    @Override
    public List<Book> getAll() {
        return bookRepository.getAll();
    }

    @Override
    public void insert(@NonNull Book book, @NonNull Author author, Genre genre, Comment comment) {

        book.setAuthor(author);

        if (genre != null) {
            Set<Genre> genres = book.getGenres();
            genres.add(genre);
            book.setGenres(genres);
            genre.setBook(book);
        }
        if (comment != null) {
            Set<Comment> comments = book.getComments();
            comments.add(comment);

            book.setComments(comments);
        }

        bookRepository.insert(book);
    }

    @Override
    public void deleteById(long id) {
        bookRepository.deleteById(id);
    }
}

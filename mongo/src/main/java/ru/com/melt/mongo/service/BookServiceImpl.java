package ru.com.melt.mongo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.com.melt.mongo.domain.Author;
import ru.com.melt.mongo.domain.Book;
import ru.com.melt.mongo.domain.Comment;
import ru.com.melt.mongo.domain.Genre;
import ru.com.melt.mongo.repository.BookRepository;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public long count() {
        return bookRepository.count();
    }

    @Override
    public Book getById(String id) {
        return bookRepository.findById(id).get();
    }

    @Override
    public List<Book> getAllBook() {
        return bookRepository.findAll();
    }

    @Override
    public void insert(String name, String description, String content, String firstName, String secondName, String genreName, String commentS) {
        Book book = new Book();
        book.setName(name);
        book.setDescription(description);
        book.setContent(content);

        Author author = new Author();
        author.setFirstName(firstName);
        author.setSecondName(secondName);

        Genre genre = new Genre();
        genre.setGenre(genreName);

        Comment comment = new Comment();
        comment.setComment(commentS);

        book.addAuthor(author);
        book.setGenre(genre);
        book.addComment(comment);

        bookRepository.save(book);
    }

    @Override
    public void deleteById(String id) {
        bookRepository.deleteById(id);
    }
}

package ru.com.melt.mongo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.com.melt.mongo.domain.Author;
import ru.com.melt.mongo.domain.Book;
import ru.com.melt.mongo.domain.Comment;
import ru.com.melt.mongo.domain.Genre;
import ru.com.melt.mongo.repository.BookRepository;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@DataMongoTest
public class BookTest {

    private static final String FIRST_NAME = "firstName";
    private static final String SECOND_NAME = "secondName";
    private static final String COMMENT = "comment";
    private static final String GENRE = "genre";
    private static final String BOOK_NAME = "bookName";
    private static final String BOOK_DESCRIPTION = "bookDescription";
    private static final String BOOK_CONTENT = "bookContent";

    @Autowired
    private BookRepository bookRepository;
    private Author author;
    private Book book;
    private Comment comment;
    private Genre genre;

    @Before
    public void init(){
        author = new Author();
        author.setFirstName(FIRST_NAME);
        author.setSecondName(SECOND_NAME);

        comment = new Comment();
        comment.setComment(COMMENT);

        genre = new Genre();
        genre.setGenre(GENRE);

        book = new Book();
        book.setName(BOOK_NAME);
        book.setContent(BOOK_CONTENT);
        book.setDescription(BOOK_DESCRIPTION);
        book.addAuthor(author);
        book.addComment(comment);
        book.setGenre(genre);

        book = bookRepository.save(book);
    }

    @Test
    public void testBookValues(){
        assertEquals(BOOK_NAME, book.getName());
        assertEquals(BOOK_DESCRIPTION, book.getDescription());
        assertEquals(BOOK_CONTENT, book.getContent());
    }

    @Test
    public void testAuthor(){
        assertNotNull(book.getAuthors());
        assertFalse(book.getAuthors().isEmpty());
    }

    @Test
    public void testComment(){
        assertNotNull(book.getComments());
        assertFalse(book.getComments().isEmpty());
    }

    @Test
    public void testGenre(){
        assertNotNull(book.getGenre());
    }

    @Test
    public void testCount(){
        assertTrue(bookRepository.count() > 0);
    }

    @Test
    public void testDeleteAll(){
        bookRepository.deleteAll();
        assertEquals(0, bookRepository.count());
    }
}

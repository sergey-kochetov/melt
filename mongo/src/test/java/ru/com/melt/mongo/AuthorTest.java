package ru.com.melt.mongo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.com.melt.mongo.domain.Author;
import ru.com.melt.mongo.repository.AuthorRepository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@DataMongoTest
public class AuthorTest {

    private static final String FIRST_NAME = "firstName";
    private static final String SECOND_NAME = "secondName";

    @Autowired
    private AuthorRepository authorRepository;
    private Author author;

    @Before
    public void init() {
        author = new Author();
        author.setFirstName(FIRST_NAME);
        author.setSecondName(SECOND_NAME);
        author = authorRepository.save(author);
    }

    @Test
    public void testAuthorNames() {
        assertEquals(FIRST_NAME, author.getFirstName());
        assertEquals(SECOND_NAME, author.getSecondName());
    }

    @Test
    public void testCount() {
        System.out.println(authorRepository.findAll());
        assertTrue(authorRepository.count() > 0);
    }

    @Test
    public void testDeleteAll() {
        authorRepository.deleteAll();
        assertEquals(0, authorRepository.count());
    }
}
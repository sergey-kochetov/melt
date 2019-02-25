package ru.com.melt;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;
import ru.com.melt.domain.Comment;
import ru.com.melt.domain.Genre;
import ru.com.melt.repos.CommentRepositoryJdbc;
import ru.com.melt.repos.GenreRepositoryJdbc;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
@ComponentScan("ru.com.melt")
public class GenreTest {
    @Autowired
    private GenreRepositoryJdbc jdbc;

    @Test
    public void whenCallCount_thenReturnOne() {
        //given
        Long actual = 1L;

        // when
        Long expected = jdbc.count();

        // then
        assertEquals(actual, expected);
    }

    @Test
    public void whenCallGetById_thenReturnAuthor() {
        //given
        String genre = "genre1";

        // when
        Genre findComment = jdbc.getById(1L);

        // then
        assertEquals("Genre(id=1, genre=genre1, book=Book{id=1, name='book1'})",
                findComment.toString());
    }

    @Test
    public void whenCallDelById_thenDelOk() {
        //given
        Long actual = 1L;

        // when
        jdbc.deleteById(1L);
        Long expected = jdbc.count();

        // then
        assertEquals(actual, expected);
    }

    @Test
    public void whenCallInsert_thenOk() {
        //given
        Long actual = 2L;
        Genre genre = new Genre();
        genre.setGenre("genre2");

        // when
        jdbc.insert(genre);
        Long expected = jdbc.count();

        // then
        assertEquals(actual, expected);
    }
}
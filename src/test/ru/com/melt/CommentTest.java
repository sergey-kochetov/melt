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
import ru.com.melt.repos.CommentRepositoryJdbc;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
@ComponentScan("ru.com.melt")
public class CommentTest {
    @Autowired
    private CommentRepositoryJdbc jdbc;

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
        String comment = "comment1";

        // when
        Comment findComment = jdbc.getById(1L);

        // then
        assertEquals(comment, findComment.getComment());
    }

    @Test
    public void whenCallDelById_thenDelOk() {
        //given
        Long actual = 0L;

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
        Comment comment = new Comment();
        comment.setComment("comment2");

        // when
        jdbc.insert(comment);
        Long expected = jdbc.count();

        // then
        assertEquals(actual, expected);
    }
}
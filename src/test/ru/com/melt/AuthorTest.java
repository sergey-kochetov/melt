package ru.com.melt;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;
import ru.com.melt.domain.Author;
import ru.com.melt.repos.author.AuthorRepositoryJdbc;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
@ComponentScan("ru.com.melt")
public class AuthorTest {

    @Autowired
    private AuthorRepositoryJdbc jdbc;

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
        String firstName = "firstName";
        String secondName = "secondName";

        // when
        Author findAuthor = jdbc.getById(1L);

        // then
        //System.out.println(findAuthor.toString());
        assertEquals(firstName, findAuthor.getFirstName());
        assertEquals(secondName, findAuthor.getSecondName());
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
        Long actual = 1L;
        Author author = new Author();
        author.setFirstName("firstName2");
        author.setSecondName("secondName2");

        // when
        jdbc.insert(author);
        Long expected = jdbc.count();

        // then
        assertEquals(
                "[Author{id=1, firstName='firstName', secondName='secondName'}, " +
                "Author{id=2, firstName='firstName2', secondName='secondName2'}]",
                jdbc.getAll().toString());
    }
}

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
import ru.com.melt.domain.Book;
import ru.com.melt.repos.AuthorRepositoryJdbc;
import ru.com.melt.repos.BookRepositoryJdbc;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
@ComponentScan("ru.com.melt")
public class BookTest {

    @Autowired
    private BookRepositoryJdbc jdbc;

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
        String name = "book1";
        String description = "description1";

        // when
        Book findBook = jdbc.getById(1L);

        // then
        //System.out.println(findAuthor.toString());
        assertEquals(name, findBook.getName());
        assertEquals(description, findBook.getDescription());
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
        Book book = new Book();
        book.setName("serg");
        book.setDescription("hello");


        // when
        jdbc.insert(book);
        Long expected = jdbc.count();

        // then
        assertEquals("[Book{id=1, name='book1'}, " +
                        "Book{id=2, name='serg'}]",
                jdbc.getAll().toString());

        assertEquals(actual, expected);
    }
}

package ru.com.melt.mongo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.com.melt.mongo.domain.Genre;
import ru.com.melt.mongo.repository.GenreRepository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@DataMongoTest
public class GenreTest {

    private static final String GENRE = "genre";

    @Autowired
    private GenreRepository genreRepository;
    private Genre genre;

    @Before
    public void init(){
        genre = new Genre();
        genre.setGenre(GENRE);
        genre = genreRepository.save(genre);
    }

    @Test
    public void testGenre(){
        assertEquals(GENRE, genre.getGenre());
    }

    @Test
    public void testCount(){
        System.out.println(genreRepository.findAll());
        assertTrue(genreRepository.count() > 0);
    }

    @Test
    public void testDeleteAll(){
        genreRepository.deleteAll();
        assertEquals(0, genreRepository.count());
    }
}
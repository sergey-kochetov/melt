package ru.com.melt.mongo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.com.melt.mongo.domain.Comment;
import ru.com.melt.mongo.repository.CommentRepository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@DataMongoTest
public class CommentTest {

    private static final String COMMENT = "comment";

    @Autowired
    private CommentRepository commentRepository;
    private Comment comment;

    @Before
    public void init(){
        comment = new Comment();
        comment.setComment(COMMENT);
        comment = commentRepository.save(comment);
    }

    @Test
    public void testComment(){
        assertEquals(COMMENT, comment.getComment());
    }

    @Test
    public void testCount(){
        System.out.println(commentRepository.findAll());
        assertTrue(commentRepository.count() > 0);
    }

    @Test
    public void testDeleteAll(){
        commentRepository.deleteAll();
        assertEquals(0, commentRepository.count());
    }
}

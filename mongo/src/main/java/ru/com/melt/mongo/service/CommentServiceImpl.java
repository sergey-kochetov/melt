package ru.com.melt.mongo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.com.melt.mongo.domain.Book;
import ru.com.melt.mongo.domain.Comment;
import ru.com.melt.mongo.repository.BookRepository;
import ru.com.melt.mongo.repository.CommentRepository;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public long count() {
        return commentRepository.count();
    }

    @Override
    public Comment getById(String id) {
        return commentRepository.findById(id).get();
    }

    @Override
    public List<Comment> getAllComment() {
        return commentRepository.findAll();
    }

    @Override
    public void insert(String idBook, String comment) {
        Comment newComment = new Comment();
        newComment.setComment(comment);

        Book book = bookRepository.findById(idBook).get();
        book.addComment(newComment);

        bookRepository.save(book);
        commentRepository.save(newComment);
    }

    @Override
    public void deleteById(String id) {
        commentRepository.deleteById(id);
    }
}

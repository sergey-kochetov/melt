package ru.com.melt.service.comment;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.com.melt.domain.Book;
import ru.com.melt.domain.Comment;
import ru.com.melt.repos.BookRepositoryJdbc;
import ru.com.melt.repos.CommentRepositoryJdbc;

import java.util.List;
import java.util.Set;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepositoryJdbc commentRepositoryJdbc;
    private final BookRepositoryJdbc bookRepositoryJdbc;

    @Autowired
    public CommentServiceImpl(CommentRepositoryJdbc commentRepositoryJdbc, BookRepositoryJdbc bookRepositoryJdbc) {
        this.commentRepositoryJdbc = commentRepositoryJdbc;
        this.bookRepositoryJdbc = bookRepositoryJdbc;
    }

    @Override
    public void insert(@NonNull Long idBook, @NonNull String comment) {
        Book book = bookRepositoryJdbc.getById(idBook);
        Comment newComment = new Comment();
        newComment.setComment(comment);

        Set<Comment> commentsBook = book.getComments();
        commentsBook.add(newComment);

        book.setComments(commentsBook);

        commentRepositoryJdbc.insert(newComment);
        bookRepositoryJdbc.insert(book);
    }

    @Override
    public Long count() {
        return commentRepositoryJdbc.count();
    }

    @Override
    public Comment getById(@NonNull long id) {
        return commentRepositoryJdbc.getById(id);
    }

    @Override
    public List<Comment> getAll() {
        return commentRepositoryJdbc.getAll();
    }

    @Override
    public void deleteById(@NonNull long id) {
        commentRepositoryJdbc.deleteById(id);
    }
}

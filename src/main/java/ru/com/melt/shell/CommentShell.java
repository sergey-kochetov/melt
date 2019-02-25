package ru.com.melt.shell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import org.springframework.util.StringUtils;
import ru.com.melt.domain.Comment;
import ru.com.melt.service.comment.CommentService;

import java.util.List;

@ShellComponent
public class CommentShell {

    private final CommentService commentService;

    @Autowired
    public CommentShell(CommentService commentService) {
        this.commentService = commentService;
    }

    @ShellMethod(key = { "comment_count" }, value = "Comment count")
    public Long commentCount() {
        return commentService.count();
    }

    @ShellMethod(key = { "comment_get" }, value = "Comment get by id")
    public String bookGetById(@ShellOption Long id) {
        return commentService.getById(id).toString();
    }

    @ShellMethod(key = { "comment_add" }, value = "Comment add id_book and comment")
    public void bookInsert(@ShellOption long idBook, @ShellOption String comment) {
        commentService.insert(idBook, comment);
    }

    @ShellMethod(key = { "comment_list" }, value = "Comment list")
    public String bookList() {
        List<Comment> allBook = commentService.getAll();
        return StringUtils.collectionToDelimitedString(
                allBook, System.lineSeparator());
    }
}

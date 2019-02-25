package ru.com.melt.shell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import org.springframework.util.StringUtils;
import ru.com.melt.domain.Author;
import ru.com.melt.domain.Book;
import ru.com.melt.service.book.BookService;

import java.util.List;

@ShellComponent
public class BookShell {

    private final BookService bookService;

    @Autowired
    public BookShell(BookService bookService) {
        this.bookService = bookService;
    }

    @ShellMethod(key = { "book_count" }, value = "Book count")
    public Long bookCount() {
        return bookService.count();
    }

    @ShellMethod(key = { "book_get" }, value = "Book get by id")
    public String bookGetById(@ShellOption Long id) {
        return bookService.getById(id).toString();
    }

    @ShellMethod("Book insert")
    public void bookInsert(@ShellOption String[] var) {
        //TODO implement
    }

    @ShellMethod(key = { "book_list" }, value = "Book get by id")
    public String bookList() {
        List<Book> allBook = bookService.getAll();
        return StringUtils.collectionToDelimitedString(
                allBook, System.lineSeparator());
    }

}

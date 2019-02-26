package ru.com.melt.mongo.shell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.com.melt.mongo.service.BookService;

@ShellComponent
public class BookShell {

    @Autowired
    private BookService bookService;

    @ShellMethod("Book count")
    public long bookCount(){
        return  bookService.count();
    }
    @ShellMethod("Book get by id")
    public String bookGetById(@ShellOption String id){
        return bookService.getById(id).toString();
    }
    @ShellMethod("Book delete by id")
    public void bookDeleteById(@ShellOption String id){
        bookService.deleteById(id);
    }
    @ShellMethod("Book insert")
    public void bookInsert(@ShellOption String name, @ShellOption String description, @ShellOption String content, @ShellOption String firstName,
                           @ShellOption String secondName, @ShellOption String genreName, @ShellOption String comment){
        bookService.insert(name, description, content, firstName, secondName, genreName, comment);
    }
    @ShellMethod("Book list")
    public String bookList(){
        return  bookService.getAllBook().toString();
    }
}

package ru.com.melt.mongo.shell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.com.melt.mongo.service.AuthorService;

@ShellComponent
public class AuthorShell {

    @Autowired
    private AuthorService authorService;

    @ShellMethod("Author count")
    public long authorCount(){
        return  authorService.count();
    }
    @ShellMethod("Author get by id")
    public String authorGetById(@ShellOption String id){
        return authorService.getById(id).toString();
    }
    @ShellMethod("Author delete by id")
    public void authorDeleteById(@ShellOption String id){
        authorService.deleteById(id);
    }
    @ShellMethod("Author insert")
    public void authorInsert(@ShellOption String firstName, @ShellOption String secondName){
        authorService.insert(firstName, secondName);
    }
    @ShellMethod("Author list")
    public String authorList(){
        return  authorService.getAllAuthor().toString();
    }
}

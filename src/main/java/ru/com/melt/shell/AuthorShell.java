package ru.com.melt.shell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import org.springframework.util.StringUtils;
import ru.com.melt.domain.Author;
import ru.com.melt.service.author.AuthorService;

import java.util.List;

@ShellComponent
public class AuthorShell {

    private final AuthorService authorService;

    @Autowired
    public AuthorShell(AuthorService authorService) {
        this.authorService = authorService;
    }

    @ShellMethod(key = { "author_count" }, value = "Author count")
    public Long authorCount() {
        return authorService.count();
    }

    @ShellMethod(key = { "author_id" }, value = "Author get by id")
    public String authorGetByUd(@ShellOption Long id) {
        return authorService.getById(id).toString();
    }

    @ShellMethod(key = { "author_list" }, value ="Author list")
    public String authorList() {
        List<Author> allAuthor = authorService.getAllAuthor();
        return StringUtils.collectionToDelimitedString(
                allAuthor, System.lineSeparator());
    }

    @ShellMethod(key = { "author_insert" }, value = "Author insert")
    public void authorInsert(@ShellOption String firstName,
                               @ShellOption String secondName) {
        authorService.insert(firstName, secondName);
    }

    @ShellMethod(key = { "author_del" }, value ="Author delete by id")
    public void authorDeleteById(@ShellOption Long id){
        authorService.deleteById(id);
    }
}

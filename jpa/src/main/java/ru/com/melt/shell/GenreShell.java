package ru.com.melt.shell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import org.springframework.util.StringUtils;
import ru.com.melt.domain.Genre;
import ru.com.melt.service.genre.GenreService;

import java.util.List;

@ShellComponent
public class GenreShell {

    private final GenreService genreService;

    @Autowired
    public GenreShell(GenreService genreService) {
        this.genreService = genreService;
    }

    @ShellMethod(key = { "genre_count" }, value = "genre count")
    public Long genreCount() {
        return genreService.count();
    }

    @ShellMethod(key = { "genre_get" }, value = "Genre get by id")
    public String genreGetById(@ShellOption Long id) {
        return genreService.getById(id).toString();
    }

    @ShellMethod(key = { "genre_add" }, value = "Genre add id_book and comment")
    public void genreInsert(@ShellOption long idBook, @ShellOption String genreName) {
        genreService.insert(idBook, genreName);
    }

    @ShellMethod(key = { "genre_list" }, value = "Genre list")
    public String genreList() {
        List<Genre> allBook = genreService.getAll();
        return StringUtils.collectionToDelimitedString(
                allBook, System.lineSeparator());
    }
}

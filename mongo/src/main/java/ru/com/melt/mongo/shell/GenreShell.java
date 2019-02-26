package ru.com.melt.mongo.shell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.com.melt.mongo.service.GenreService;

@ShellComponent
public class GenreShell {

    @Autowired
    private GenreService genreService;

    @ShellMethod("Genre count")
    public long genreCount(){
        return  genreService.count();
    }
    @ShellMethod("Genre get by id")
    public String genreGetById(@ShellOption String id){
        return genreService.getById(id).toString();
    }
    @ShellMethod("Genre delete by id")
    public void genreDeleteById(@ShellOption String id){
        genreService.deleteById(id);
    }
    @ShellMethod("Genre insert")
    public void genreInsert(@ShellOption String idBook, @ShellOption String genre){
        genreService.insert(idBook, genre);
    }
    @ShellMethod("Genre list")
    public String genreList(){
        return  genreService.getAllGenre().toString();
    }
}

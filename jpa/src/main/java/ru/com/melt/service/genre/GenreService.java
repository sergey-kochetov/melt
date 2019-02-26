package ru.com.melt.service.genre;

import lombok.NonNull;
import ru.com.melt.domain.Comment;
import ru.com.melt.domain.Genre;
import ru.com.melt.service.EntityService;

public interface GenreService extends EntityService<Genre> {

    void insert(@NonNull long idBook, @NonNull String genreName);
}

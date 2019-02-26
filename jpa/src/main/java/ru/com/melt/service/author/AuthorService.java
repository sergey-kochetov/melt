package ru.com.melt.service.author;

import lombok.NonNull;
import ru.com.melt.domain.Author;
import ru.com.melt.service.EntityService;

public interface AuthorService extends EntityService<Author> {

    void insert(@NonNull String firstName, @NonNull String secondName);
}

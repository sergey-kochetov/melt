package ru.com.melt.service.author;

import lombok.NonNull;
import ru.com.melt.domain.Author;

import java.util.List;

public interface AuthorService {

    long count();

    Author getById(@NonNull long id);

    List<Author> getAllAuthor();

    void insert(@NonNull String firstName, @NonNull String secondName);

    void deleteById(@NonNull long id);
}

package ru.com.melt.service.book;

import lombok.NonNull;
import ru.com.melt.domain.Author;
import ru.com.melt.domain.Book;
import ru.com.melt.domain.Comment;
import ru.com.melt.domain.Genre;
import ru.com.melt.service.EntityService;

public interface BookService extends EntityService<Book> {

    void insert(@NonNull Book book, @NonNull Author author, Genre genre, Comment comment);
}

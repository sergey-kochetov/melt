package ru.com.melt.service.author;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.com.melt.domain.Author;
import ru.com.melt.repos.AuthorRepositoryJdbc;
import ru.com.melt.service.EntityService;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepositoryJdbc authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepositoryJdbc authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Long count() {
        return authorRepository.count();
    }

    @Override
    public Author getById(@NonNull long id) {
        return authorRepository.getById(id);
    }

    @Override
    public List<Author> getAll() {
        return authorRepository.getAll();
    }

    @Override
    public void insert(@NonNull String firstName, @NonNull String secondName) {
        Author author = new Author();
        author.setFirstName(firstName);
        author.setSecondName(secondName);
        authorRepository.insert(author);
    }

    @Override
    public void deleteById(long id) {
        authorRepository.deleteById(id);
    }
}

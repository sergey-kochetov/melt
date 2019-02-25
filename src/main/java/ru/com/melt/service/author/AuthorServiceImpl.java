package ru.com.melt.service.author;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.com.melt.domain.Author;
import ru.com.melt.repos.author.AuthorRepository;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public long count() {
        return authorRepository.count();
    }

    @Override
    public Author getById(@NonNull long id) {
        return authorRepository.getById(id);
    }

    @Override
    public List<Author> getAllAuthor() {
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

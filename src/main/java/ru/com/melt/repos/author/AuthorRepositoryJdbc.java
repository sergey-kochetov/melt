package ru.com.melt.repos.author;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.com.melt.domain.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class AuthorRepositoryJdbc implements AuthorRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public Long count() {
        return (Long) manager
                .createQuery("SELECT count(a) from Author a")
                .getSingleResult();
    }

    @Override
    public Author getById(Long id) {
        return manager.find(Author.class, id);
    }

    @Override
    public List<Author> getAll() {
        return manager
                .createQuery("SELECT a FROM Author a", Author.class)
                .getResultList();
    }

    @Override
    public void deleteById(Long id) {
        Author author = getById(id);
        manager.remove(author);
    }

    @Override
    public void insert(Author author) {
        manager.persist(author);
    }
}

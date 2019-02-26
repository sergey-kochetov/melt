package ru.com.melt.repos;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.com.melt.domain.Genre;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class GenreRepositoryJdbc implements EntityRepository<Genre> {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public Long count() {
        return (Long) manager
                .createQuery("SELECT count(g) FROM Genre g")
                .getSingleResult();
    }

    @Override
    public Genre getById(Long id) {
        return manager.find(Genre.class, id);
    }

    @Override
    public List<Genre> getAll() {
        return manager
                .createQuery("SELECT g FROM Genre g", Genre.class)
                .getResultList();
    }

    @Override
    public void deleteById(Long id) {
        Genre genre = manager.find(Genre.class, id);
        manager.remove(genre);
    }

    @Override
    public void insert(Genre genre) {
        manager.persist(genre);
    }
}

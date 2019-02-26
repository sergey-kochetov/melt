package ru.com.melt.repos;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.com.melt.domain.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class BookRepositoryJdbc implements EntityRepository<Book> {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public Long count() {
        return (Long) manager
                .createQuery("SELECT count(b) from Book b")
                .getSingleResult();
    }

    @Override
    public Book getById(Long id) {
        return manager.find(Book.class, id);
    }

    @Override
    public List<Book> getAll() {
        return manager
                .createQuery("SELECT b FROM Book b", Book.class)
                .getResultList();
    }

    @Override
    public void deleteById(Long id) {
        Book findBook = manager.find(Book.class, id);
        manager.remove(findBook);
    }

    @Override
    public void insert(Book book) {
        manager.persist(book);
    }
}

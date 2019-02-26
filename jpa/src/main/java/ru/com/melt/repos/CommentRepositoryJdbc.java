package ru.com.melt.repos;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.com.melt.domain.Comment;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class CommentRepositoryJdbc implements   EntityRepository<Comment> {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public Long count() {
        return (Long) manager
                .createQuery("SELECT count(c) FROM Comment c")
                .getSingleResult();
    }

    @Override
    public Comment getById(Long id) {
        return manager.find(Comment.class, id);
    }

    @Override
    public List<Comment> getAll() {
        return manager
                .createQuery("SELECT c FROM Comment c", Comment.class)
                .getResultList();
    }

    @Override
    public void deleteById(Long id) {
        Comment comment = manager.find(Comment.class, id);
        manager.remove(comment);
    }

    @Override
    public void insert(Comment comment) {
        manager.persist(comment);
    }
}

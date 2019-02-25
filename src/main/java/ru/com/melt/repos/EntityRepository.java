package ru.com.melt.repos;

import java.util.List;

public interface EntityRepository<T> {

    Long count();

    T getById(Long id);

    List<T> getAll();

    void deleteById(Long id);

    void insert(T value);
}

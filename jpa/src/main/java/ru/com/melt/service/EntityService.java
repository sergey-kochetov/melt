package ru.com.melt.service;

import lombok.NonNull;

import java.util.List;

public interface EntityService<T> {

    Long count();

    T getById(@NonNull long id);

    List<T> getAll();

    void deleteById(@NonNull long id);
}

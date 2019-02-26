package ru.com.melt.mongo.service;

import ru.com.melt.mongo.domain.Comment;

import java.util.List;

public interface CommentService {
    long count();

    Comment getById(String id);

    List<Comment> getAllComment();

    void insert(String idBook, String comment);

    void deleteById(String id);
}

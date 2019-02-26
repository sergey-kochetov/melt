package ru.com.melt.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.com.melt.mongo.domain.Comment;

public interface CommentRepository extends MongoRepository<Comment, String> {
}

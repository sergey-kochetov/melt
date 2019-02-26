package ru.com.melt.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.com.melt.mongo.domain.Author;

public interface AuthorRepository extends MongoRepository<Author, String> {
}

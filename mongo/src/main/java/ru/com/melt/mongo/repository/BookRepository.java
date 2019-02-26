package ru.com.melt.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.com.melt.mongo.domain.Book;

public interface BookRepository extends MongoRepository<Book, String> {
}

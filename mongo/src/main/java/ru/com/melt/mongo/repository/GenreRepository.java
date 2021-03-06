package ru.com.melt.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.com.melt.mongo.domain.Genre;

public interface GenreRepository extends MongoRepository<Genre, String> {
}

package ru.com.melt.repos;

import org.springframework.data.repository.CrudRepository;
import ru.com.melt.domain.Message;

import java.util.List;

public interface MessageRepo extends CrudRepository<Message, Long> {

    List<Message> findByTag(String tag);
}

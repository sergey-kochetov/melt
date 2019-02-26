package ru.com.melt.mongo.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@EqualsAndHashCode(of = "id")
public class Author {

    @Id
    private String id;

    private String firstName;
    private String secondName;
}
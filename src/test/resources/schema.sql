CREATE TABLE author_table(
  id          BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  first_name  VARCHAR(255),
  second_name VARCHAR(255),
  book_id     BIGINT
);

CREATE TABLE book_comments_detail(
  comment_id  BIGINT,
  book_id     BIGINT
);

CREATE TABLE book_table(
  id          BIGINT PRIMARY KEY AUTO_INCREMENT,
  name        VARCHAR(255),
  description VARCHAR(255),
  author_id   BIGINT
);

CREATE TABLE comment_table(
  id         BIGINT PRIMARY KEY AUTO_INCREMENT,
  comment    VARCHAR(255)
);

CREATE TABLE genre_table(
  id         BIGINT PRIMARY KEY AUTO_INCREMENT,
  genre      VARCHAR(255),
  book_id    BIGINT
);
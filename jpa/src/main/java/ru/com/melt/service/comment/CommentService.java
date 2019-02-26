package ru.com.melt.service.comment;

import lombok.NonNull;
import ru.com.melt.domain.Comment;
import ru.com.melt.service.EntityService;

public interface CommentService extends EntityService<Comment> {

    void insert(@NonNull Long idBook, @NonNull String comment);
}

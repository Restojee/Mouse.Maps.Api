package com.mouse.maps.comments.queries;

import com.mouse.maps.comments.models.Comment;

import java.util.Collection;

public interface GetCommentsByUser {
    public Collection<Comment> invoke(Integer userId);
}

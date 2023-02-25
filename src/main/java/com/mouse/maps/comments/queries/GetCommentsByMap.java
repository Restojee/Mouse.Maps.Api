package com.mouse.maps.comments.queries;

import com.mouse.maps.comments.models.Comment;

import java.util.Collection;

public interface GetCommentsByMap {
    public Collection<Comment> invoke(Integer mapId);
}

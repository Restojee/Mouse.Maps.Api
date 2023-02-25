package com.mouse.maps.comments.queries;

import com.mouse.maps.comments.models.Comment;
import com.mouse.maps.comments.models.CreateCommentRequest;

import java.util.Collection;

public interface CreateComment {
    public Comment invoke(CreateCommentRequest request);
}

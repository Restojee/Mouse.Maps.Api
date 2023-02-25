package com.mouse.maps.comments.queries.read;

import com.mouse.maps.comments.data.CommentRepository;
import com.mouse.maps.comments.mappers.CommentProfile;
import com.mouse.maps.comments.models.Comment;
import com.mouse.maps.comments.queries.GetCommentsByMap;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.Collectors;

@Component
public class GetCommentsByMapQuery implements GetCommentsByMap {

    @Autowired
    protected CommentRepository commentRepository;

    @Autowired
    protected CommentProfile commentProfile;

    @Transactional
    public Collection<Comment> invoke(Integer mapId) {
        return this.commentRepository
            .findAllByMap_Id(mapId)
            .map(commentProfile::toCommentFromMapCommentEntity)
            .collect(Collectors.toList());
    }
}

package com.mouse.maps.comments.queries.write;

import com.mouse.maps.comments.data.CommentRepository;
import com.mouse.maps.comments.mappers.CommentProfile;
import com.mouse.maps.comments.models.Comment;
import com.mouse.maps.comments.models.CreateCommentRequest;
import com.mouse.maps.comments.queries.CreateComment;
import com.mouse.maps.entities.MapCommentEntity;
import com.mouse.maps.entities.MapEntity;
import com.mouse.maps.entities.UserEntity;
import com.mouse.maps.users.queries.FindCurrentUser;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateCommentQuery implements CreateComment {

    @Autowired
    protected CommentRepository commentRepository;

    @Autowired
    protected CommentProfile commentProfile;

    @Autowired
    protected FindCurrentUser findCurrentUser;

    public Comment invoke(CreateCommentRequest request) {
        val payload = new MapCommentEntity();

        val map = new MapEntity();
        map.setId(request.mapId);

        val user = new UserEntity();
        user.setId(this.findCurrentUser.invoke().getId());

        payload.setUser(user);
        payload.setMap(map);
        payload.setText(request.text);

        return this.commentProfile.toCommentFromMapCommentEntity(
            this.commentRepository.save(payload)
        );
    }
}

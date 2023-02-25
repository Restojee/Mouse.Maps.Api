package com.mouse.maps.comments;

import com.mouse.maps.comments.models.Comment;
import com.mouse.maps.comments.models.CreateCommentRequest;
import com.mouse.maps.comments.queries.CreateComment;
import com.mouse.maps.comments.queries.DeleteComment;
import com.mouse.maps.comments.queries.GetCommentsByMap;
import com.mouse.maps.comments.queries.GetCommentsByUser;
import com.mouse.maps.maps.models.GetMapsRequest;
import com.mouse.maps.maps.models.Map;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@SecurityRequirement(name = "bearerAuth")
@PreAuthorize("isAuthenticated()")
@Tag(name = "Comments")
@RequestMapping("/comments")
@RestController
public class CommentsController {

    @Autowired
    protected GetCommentsByUser getCommentsByUser;

    @Autowired
    protected GetCommentsByMap getCommentsByMap;

    @Autowired
    protected CreateComment createComment;

    @GetMapping("/user/{userId}")
    @Operation(
        description = "GetCommentsByUserId",
        security = @SecurityRequirement(name = "bearerAuth")
    )
    public Collection<Comment> getCommentsByUserId(@PathVariable Integer userId) {
        return this.getCommentsByUser.invoke(userId);
    }

    @GetMapping("/map/{mapId}")
    @Operation(
        description = "GetCommentsByMapId",
        security = @SecurityRequirement(name = "bearerAuth")
    )
    public Collection<Comment> getCommentsByMapId(@PathVariable Integer mapId) {
        return this.getCommentsByMap.invoke(mapId);
    }

    @PostMapping
    @Operation(
        description = "CreateComment",
        security = @SecurityRequirement(name = "bearerAuth")
    )
    public Comment createComment(@RequestBody CreateCommentRequest request) {
        return this.createComment.invoke(request);
    }
}

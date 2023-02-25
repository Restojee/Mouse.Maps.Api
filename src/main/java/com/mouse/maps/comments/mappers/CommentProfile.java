package com.mouse.maps.comments.mappers;

import com.mouse.maps.comments.models.Comment;
import com.mouse.maps.comments.models.CreateCommentRequest;
import com.mouse.maps.entities.MapCommentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
    componentModel = "spring",
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface CommentProfile {

    @Mapping(target = "user", source = "user")
    Comment toCommentFromMapCommentEntity(MapCommentEntity commentEntity);

    @Mapping(target = "user", source = "user")
    MapCommentEntity toMapCommentEntityFromComment(Comment comment);

    MapCommentEntity toMapCommentEntityFromCreateCommentRequest(CreateCommentRequest createCommentRequest);

    MapCommentEntity toMapCommentEntityFromUpdateCommentRequest(MapCommentEntity commentEntity);
}

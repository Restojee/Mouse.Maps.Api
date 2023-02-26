package com.mouse.maps.tags.mappers;

import com.mouse.maps.entities.TagEntity;
import com.mouse.maps.tags.models.CreateTagRequest;
import com.mouse.maps.tags.models.Tag;
import com.mouse.maps.tags.models.UpdateTagRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
    componentModel = "spring",
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface TagProfile {
    Tag toTagFromTagEntity(TagEntity tagEntity);

    TagEntity toTagEntityFromTag(Tag tag);

    TagEntity toTagEntityFromCreateTagRequest(CreateTagRequest request);

    @Mapping(target = "id", source = "tagId")
    TagEntity toTagEntityFromUpdateTagRequest(@MappingTarget TagEntity tagEntity, UpdateTagRequest request);
}

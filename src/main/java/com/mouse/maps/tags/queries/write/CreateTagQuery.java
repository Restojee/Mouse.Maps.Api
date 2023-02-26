package com.mouse.maps.tags.queries.write;

import com.mouse.maps.exceptions.BadRequestException;
import com.mouse.maps.tags.data.TagRepository;
import com.mouse.maps.tags.models.CreateTagRequest;
import com.mouse.maps.tags.models.Tag;
import com.mouse.maps.tags.queries.CreateTag;
import com.mouse.maps.tags.mappers.TagProfile;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateTagQuery implements CreateTag {

    @Autowired
    protected TagRepository tagRepository;

    @Autowired
    protected TagProfile tagProfile;

    @Override
    public Tag invoke(CreateTagRequest request) {
        val foundTag = this.tagRepository.findByName(request.name);

        if (foundTag.isPresent()) {
            throw new BadRequestException("Тег с указанным именем уже существует");
        }

        val payload = this.tagProfile.toTagEntityFromCreateTagRequest(request);

        return this.tagProfile.toTagFromTagEntity(
            this.tagRepository.save(payload )
        );
    }
}

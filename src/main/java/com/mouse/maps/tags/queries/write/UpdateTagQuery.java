package com.mouse.maps.tags.queries.write;

import com.mouse.maps.exceptions.BadRequestException;
import com.mouse.maps.tags.models.Tag;
import com.mouse.maps.tags.models.UpdateTagRequest;
import com.mouse.maps.tags.queries.UpdateTag;
import com.mouse.maps.tags.data.TagRepository;
import com.mouse.maps.tags.mappers.TagProfile;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateTagQuery implements UpdateTag {

    @Autowired
    protected TagRepository tagRepository;

    @Autowired
    protected TagProfile tagProfile;

    @Override
    public Tag invoke(UpdateTagRequest request) {
        val foundTag = this.tagRepository.findById(request.tagId);

        if (!foundTag.isPresent()) {
            throw new BadRequestException("Тег с указанным идентификатором не существует");
        }

        val payload = this.tagProfile.toTagEntityFromUpdateTagRequest(foundTag.get(), request);

        return this.tagProfile.toTagFromTagEntity(
            this.tagRepository.save(payload )
        );
    }
}

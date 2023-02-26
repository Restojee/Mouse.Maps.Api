package com.mouse.maps.tags.queries.read;

import com.mouse.maps.exceptions.BadRequestException;
import com.mouse.maps.tags.data.TagRepository;
import com.mouse.maps.tags.models.Tag;
import com.mouse.maps.tags.queries.GetTag;
import com.mouse.maps.tags.mappers.TagProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetTagQuery implements GetTag {

    @Autowired
    protected TagRepository tagRepository;

    @Autowired
    protected TagProfile tagProfile;

    @Override
    public Tag invoke(Integer tagId) {
       return this.tagRepository.findById(tagId)
           .map(tagProfile::toTagFromTagEntity)
           .orElseThrow(() -> new BadRequestException("Тег с таким идентификатором не найден"));
    }
}

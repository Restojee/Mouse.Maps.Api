package com.mouse.maps.tags.queries.read;

import com.mouse.maps.tags.data.TagRepository;
import com.mouse.maps.tags.models.Tag;
import com.mouse.maps.tags.queries.GetTags;
import com.mouse.maps.tags.mappers.TagProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.Collectors;

@Component
public class GetTagsQuery implements GetTags {

    @Autowired
    protected TagRepository tagRepository;

    @Autowired
    protected TagProfile tagProfile;

    @Override
    public Collection<Tag> invoke() {
        return this.tagRepository.findAll()
            .stream()
            .map(tagProfile::toTagFromTagEntity)
            .collect(Collectors.toList());
    }
}

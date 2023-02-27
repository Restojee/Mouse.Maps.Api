package com.mouse.maps.maps.queries.write;

import com.mouse.maps.entities.MapEntity;
import com.mouse.maps.entities.MapTagEntity;
import com.mouse.maps.entities.TagEntity;
import com.mouse.maps.exceptions.BadRequestException;
import com.mouse.maps.maps.data.MapRepository;
import com.mouse.maps.maps.data.MapTagRepository;
import com.mouse.maps.maps.mappers.MapProfile;
import com.mouse.maps.maps.models.Map;
import com.mouse.maps.maps.models.SetMapTagRequest;
import com.mouse.maps.maps.queries.SetMapTags;
import com.mouse.maps.tags.data.TagRepository;
import jakarta.transaction.Transactional;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class SetMapTagsQuery implements SetMapTags {

    @Autowired
    private MapTagRepository mapTagRepository;

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private MapRepository mapRepository;

    @Autowired
    private MapProfile mapProfile;

    @Override
    public Map invoke(SetMapTagRequest request) {
        val foundMap = this.mapRepository.findById(request.getMapId());

        if (!foundMap.isPresent()) {
            throw new BadRequestException("Запрашиваемая карта не найдена");
        }

        val mapEntity = foundMap.get();

        Set<Integer> tagIds = (Set<Integer>) request.getTagIds();
        if (tagIds != null) {
            Collection<TagEntity> tags = tagRepository.findAllById(tagIds);
            mapEntity.getTags().clear();
            mapEntity.getTags().addAll(tags);
        }

        return this.mapProfile.toMapFromMapEntity(mapEntity);
    }
}

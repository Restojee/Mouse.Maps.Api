package com.mouse.maps.tags.data;

import com.mouse.maps.entities.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TagRepository extends JpaRepository<TagEntity, Integer> {
    public Optional<TagEntity> findByName(String tagName);
}

package com.mouse.maps.comments.data;

import com.mouse.maps.entities.MapCommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.stream.Stream;

public interface CommentRepository extends JpaRepository<MapCommentEntity, Integer> {
    public Stream<MapCommentEntity> findAllByMap_Id(Integer mapId);

    public Stream<MapCommentEntity> findAllByUser_Id(Integer userId);
}

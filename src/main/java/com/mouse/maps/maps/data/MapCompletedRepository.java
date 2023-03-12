package com.mouse.maps.maps.data;

import com.mouse.maps.entities.MapCompletedEntity;
import com.mouse.maps.entities.MapFavoriteEntity;
import com.mouse.maps.maps.models.CompletedMap;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Transactional
@Repository
public interface MapCompletedRepository extends JpaRepository<MapCompletedEntity, Integer> {
    public Optional<MapCompletedEntity> findByUserIdAndMapId(Integer userId, Integer mapId);
}

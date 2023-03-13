package com.mouse.maps.maps.data;

import com.mouse.maps.entities.MapCompletedEntity;
import com.mouse.maps.entities.MapFavoriteEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Transactional
@Repository
public interface MapFavoriteRepository extends JpaRepository<MapFavoriteEntity, Integer> {
    public Optional<MapFavoriteEntity> findByUserIdAndMapId(Integer userId, Integer mapId);
}

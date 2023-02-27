package com.mouse.maps.maps.data;

import com.mouse.maps.entities.MapFavoriteEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface MapFavoriteRepository extends JpaRepository<MapFavoriteEntity, Integer> {
}

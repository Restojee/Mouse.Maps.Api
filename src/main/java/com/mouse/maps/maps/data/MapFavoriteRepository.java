package com.mouse.maps.maps.data;

import com.mouse.maps.entities.MapFavoriteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MapFavoriteRepository extends JpaRepository<MapFavoriteEntity, Integer> {
}

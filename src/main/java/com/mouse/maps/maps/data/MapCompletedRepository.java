package com.mouse.maps.maps.data;

import com.mouse.maps.entities.MapCompletedEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Transactional
@Repository
public interface MapCompletedRepository extends JpaRepository<MapCompletedEntity, Integer> {
}

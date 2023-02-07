package com.mouse.maps.maps.data;

import com.mouse.maps.entities.MapEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.stream.Stream;

@Repository
public interface MapRepository extends JpaRepository<MapEntity, Integer>, PagingAndSortingRepository<MapEntity, Integer> {

    Optional<MapEntity> findByName(String name);

    Stream<MapEntity> findAllByUser_Id(Integer userId, Pageable pageable);

    Stream<MapEntity> findAllByCompleted_UserId(Integer completedUserId, Pageable pageable);

    Stream<MapEntity> findAllByFavorites_UserId(Integer favoriteUserId, Pageable pageable);
}

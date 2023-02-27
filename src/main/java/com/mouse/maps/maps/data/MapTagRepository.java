package com.mouse.maps.maps.data;

import com.mouse.maps.entities.MapEntity;
import com.mouse.maps.entities.MapTagEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.stream.Stream;

@Transactional
@Repository
public interface MapTagRepository extends JpaRepository<MapTagEntity, Integer> {

}

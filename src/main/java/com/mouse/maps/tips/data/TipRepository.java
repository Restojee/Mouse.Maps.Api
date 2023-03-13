package com.mouse.maps.tips.data;

import com.mouse.maps.entities.TipEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Transactional
@Repository
public interface TipRepository extends JpaRepository<TipEntity, Integer> {

}
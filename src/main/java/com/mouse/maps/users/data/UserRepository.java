package com.mouse.maps.users.data;

import com.mouse.maps.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface UserRepository  extends JpaRepository<UserEntity, Integer>, PagingAndSortingRepository<UserEntity, Integer> {
    Optional<UserEntity> findByUsername(String name);
}

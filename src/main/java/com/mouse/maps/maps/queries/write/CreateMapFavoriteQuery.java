package com.mouse.maps.maps.queries.write;

import com.mouse.maps.entities.MapFavoriteEntity;
import com.mouse.maps.entities.UserEntity;
import com.mouse.maps.exceptions.BadRequestException;
import com.mouse.maps.maps.data.MapFavoriteRepository;
import com.mouse.maps.maps.data.MapRepository;
import com.mouse.maps.maps.queries.CreateMapFavorite;
import com.mouse.maps.services.FileService;
import com.mouse.maps.users.queries.FindCurrentUser;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateMapFavoriteQuery implements CreateMapFavorite {
    @Autowired
    public MapRepository mapRepository;

    @Autowired
    public MapFavoriteRepository mapFavoriteRepository;

    @Autowired
    public FindCurrentUser findCurrentUser;

    @Autowired
    public FileService fileService;

    public void invoke(Integer mapId){
        val map = mapRepository.findById(mapId)
                .orElseThrow(() -> new BadRequestException("Запрашиваемая карта не найдена"));

        val currentUserId = findCurrentUser.invoke().getId();

        mapFavoriteRepository.findByUserIdAndMapId(currentUserId, mapId)
            .orElseGet(() -> {
                val user = UserEntity.builder().id(currentUserId).build();

                val newFavorite = MapFavoriteEntity
                        .builder()
                        .map(map)
                        .user(user)
                        .build();

                return mapFavoriteRepository.save(newFavorite);
            });
    }

}

package com.mouse.maps.maps.queries.write;

import com.mouse.maps.exceptions.BadRequestException;
import com.mouse.maps.maps.data.MapFavoriteRepository;
import com.mouse.maps.maps.data.MapRepository;
import com.mouse.maps.maps.queries.RemoveMapFavorite;
import com.mouse.maps.users.queries.FindCurrentUser;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RemoveFavoriteMapQuery implements RemoveMapFavorite {

    @Autowired
    public MapRepository mapRepository;

    @Autowired
    public MapFavoriteRepository mapFavoriteRepository;

    @Autowired
    public FindCurrentUser findCurrentUser;

    public void invoke(Integer mapId) {
        val mapEntity = this.mapRepository.findById(mapId);

        if (!mapEntity.isPresent()) {
            throw new BadRequestException("Запрашиваемая карта не найдена");
        }

        val currentUserId = this.findCurrentUser.invoke().getId();

        val favoriteEntity = this.mapFavoriteRepository.findByUserIdAndMapId(mapId, currentUserId);

        favoriteEntity.ifPresent(mapFavoriteEntity -> this.mapFavoriteRepository.delete(mapFavoriteEntity));
    }
}

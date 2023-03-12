package com.mouse.maps.maps.queries.write;

import com.mouse.maps.exceptions.BadRequestException;
import com.mouse.maps.maps.data.MapCompletedRepository;
import com.mouse.maps.maps.data.MapRepository;
import com.mouse.maps.maps.queries.RemoveCompletedMap;
import com.mouse.maps.users.queries.FindCurrentUser;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RemoveCompletedMapQuery implements RemoveCompletedMap {
    @Autowired
    public MapRepository mapRepository;

    @Autowired
    public MapCompletedRepository mapCompletedRepository;

    @Autowired
    public FindCurrentUser findCurrentUser;

    public void invoke(Integer mapId) {
        val mapEntity = this.mapRepository.findById(mapId);

        if (!mapEntity.isPresent()) {
            throw new BadRequestException("Запрашиваемая карта не найдена");
        }

        val currentUserId = this.findCurrentUser.invoke().getId();

         val isUserEquals =
            mapEntity
                .get()
                .getUser()
                .getId()
                .equals(currentUserId);

        if (!isUserEquals) {
            throw new BadRequestException("Нельзя убрать из выполненных карт чужую карту");
        }

        this.mapCompletedRepository.deleteById(mapId);
    }
}

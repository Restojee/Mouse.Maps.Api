package com.mouse.maps.maps.queries.write;

import lombok.val;
import com.mouse.maps.exceptions.BadRequestException;
import com.mouse.maps.maps.data.MapRepository;
import com.mouse.maps.maps.mappers.MapProfile;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class DeleteMapQuery {
    private final MapRepository mapRepository;

    public DeleteMapQuery(MapRepository mapRepository, MapProfile mapProfile) {
        this.mapRepository = mapRepository;
    }

    public void invoke(Integer mapId){
       val mapEntity = this.mapRepository.findById(mapId);
       if (!mapEntity.isPresent()) {
           throw new BadRequestException("Запрашиваемая карта не найдена");
       }
       this.mapRepository.deleteById(mapId);
    }
}

package com.mouse.maps.maps.queries.write;

import com.mouse.maps.maps.queries.DeleteMap;
import lombok.val;
import com.mouse.maps.exceptions.BadRequestException;
import com.mouse.maps.maps.data.MapRepository;
import org.springframework.stereotype.Component;

@Component
public class DeleteMapQuery implements DeleteMap {
    private final MapRepository mapRepository;

    public DeleteMapQuery(MapRepository mapRepository) {
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

package com.mouse.maps.maps.queries.read;

import jakarta.transaction.Transactional;
import com.mouse.maps.exceptions.BadRequestException;
import com.mouse.maps.maps.queries.GetMap;
import com.mouse.maps.maps.data.MapRepository;
import com.mouse.maps.maps.mappers.MapProfile;
import com.mouse.maps.maps.models.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class GetMapQuery implements GetMap {

    @Autowired
    protected MapRepository mapRepository;

    @Autowired
    protected MapProfile mapProfile;

    @Transactional
    public Map invoke(Integer mapId) {
        return mapRepository.findById(mapId)
            .map(mapProfile::toMapFromMapEntity)
            .orElseThrow(() -> new BadRequestException("Запрашиваемая карта не найдена"));

    }
}

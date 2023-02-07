package com.mouse.maps.maps.queries.read;

import jakarta.transaction.Transactional;
import com.mouse.maps.exceptions.BadRequestException;
import com.mouse.maps.maps.queries.GetMapById;
import com.mouse.maps.maps.data.MapRepository;
import com.mouse.maps.maps.mappers.MapProfile;
import com.mouse.maps.maps.models.Map;
import org.springframework.stereotype.Service;

@Service
public class GetMapQuery implements GetMapById {
    private final MapRepository mapRepository;

    private final MapProfile mapProfile;

    public GetMapQuery(MapProfile mapProfile, MapRepository mapRepository) {
        this.mapRepository = mapRepository;
        this.mapProfile = mapProfile;
    }

    @Transactional
    public Map invoke(Integer mapId) {
        return mapRepository.findById(mapId)
            .map(mapProfile::toMapFromMapEntity)
            .orElseThrow(() -> new BadRequestException("Запрашиваемая карта не найдена"));

    }
}

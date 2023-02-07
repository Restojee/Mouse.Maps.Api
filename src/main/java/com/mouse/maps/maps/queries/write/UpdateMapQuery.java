package com.mouse.maps.maps.queries.write;

import com.mouse.maps.exceptions.BadRequestException;
import com.mouse.maps.maps.queries.UpdateMap;
import com.mouse.maps.maps.data.MapRepository;
import com.mouse.maps.maps.mappers.MapProfile;
import com.mouse.maps.maps.models.UpdateMapRequest;
import com.mouse.maps.maps.models.Map;
import org.springframework.stereotype.Service;

@Service
public class UpdateMapQuery implements UpdateMap {
    private final MapRepository mapRepository;

    private final MapProfile mapProfile;

    public UpdateMapQuery(MapRepository mapRepository, MapProfile mapProfile) {
        this.mapRepository = mapRepository;
        this.mapProfile = mapProfile;
    }

    public Map invoke(UpdateMapRequest request) {
        return this.mapRepository.findById(request.getId())
            .map(mapEntity -> this.mapProfile.toMapFromMapEntity(
                this.mapRepository.save(
                    this.mapProfile.toMapEntityFromUpdateMapRequest(mapEntity, request)
                ))
            )
            .orElseThrow(() -> new BadRequestException("Запрашиваемая карта не найдена"));
    }
}

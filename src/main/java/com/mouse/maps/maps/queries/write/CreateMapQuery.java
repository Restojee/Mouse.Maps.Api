package com.mouse.maps.maps.queries.write;

import com.mouse.maps.maps.queries.CreateMap;
import com.mouse.maps.maps.data.MapRepository;
import com.mouse.maps.maps.mappers.MapProfile;
import com.mouse.maps.maps.models.CreateMapRequest;
import com.mouse.maps.maps.models.Map;
import org.springframework.stereotype.Service;

@Service
public class CreateMapQuery implements CreateMap {
    private final MapRepository mapRepository;

    private final MapProfile mapProfile;

    public CreateMapQuery(MapRepository mapRepository, MapProfile mapProfile) {
        this.mapRepository = mapRepository;
        this.mapProfile = mapProfile;
    }

    public Map invoke(CreateMapRequest request) {
        return this.mapProfile.toMapFromMapEntity(
           this.mapRepository.save(this.mapProfile.toMapEntityFromCreateMapRequest(request))
        );
    }
}

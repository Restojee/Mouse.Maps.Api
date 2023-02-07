package com.mouse.maps.maps.queries.read;

import jakarta.transaction.Transactional;
import com.mouse.maps.common.Paginate;
import com.mouse.maps.maps.queries.GetCompletedMapsByUser;
import com.mouse.maps.maps.data.MapRepository;
import com.mouse.maps.maps.mappers.MapProfile;
import com.mouse.maps.maps.models.GetMapsRequest;
import com.mouse.maps.maps.models.Map;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class GetCompletedMapsQuery implements GetCompletedMapsByUser {
    private final MapRepository mapRepository;

    private final MapProfile mapProfile;

    public GetCompletedMapsQuery(MapRepository mapRepository, MapProfile mapProfile) {
        this.mapRepository = mapRepository;
        this.mapProfile = mapProfile;
    }

    @Transactional
    public Collection<Map> invoke(GetMapsRequest getCompletedMapsRequest) {
        return this.mapRepository
            .findAllByCompleted_UserId(
                getCompletedMapsRequest.getUserId(),
                Paginate.getPageRequest(getCompletedMapsRequest)
            )
            .map(mapProfile::toMapFromMapEntity)
            .collect(Collectors.toList());
    }
}

package com.mouse.maps.maps.queries.read;

import jakarta.transaction.Transactional;
import com.mouse.maps.maps.queries.GetMapsByUser;
import org.springframework.stereotype.Service;

import com.mouse.maps.common.Paginate;
import com.mouse.maps.maps.models.GetMapsRequest;
import com.mouse.maps.maps.models.Map;

import com.mouse.maps.maps.mappers.MapProfile;
import com.mouse.maps.maps.data.MapRepository;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class GetMapsQuery implements GetMapsByUser {
    private final MapRepository mapRepository;

    private final MapProfile mapProfile;

    public GetMapsQuery(MapRepository mapRepository, MapProfile mapProfile) {
        this.mapRepository = mapRepository;
        this.mapProfile = mapProfile;
    }

    @Transactional
    public Collection<Map> invoke(GetMapsRequest getMapsRequest) {
        return this.mapRepository
            .findAllByUser_Id(
                getMapsRequest.getUserId(),
                Paginate.getPageRequest(getMapsRequest)
            )
            .map(mapProfile::toMapFromMapEntity)
            .collect(Collectors.toList());
    }
}

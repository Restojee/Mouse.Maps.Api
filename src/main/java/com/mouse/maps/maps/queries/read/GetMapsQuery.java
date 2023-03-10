package com.mouse.maps.maps.queries.read;

import com.mouse.maps.common.Paginate;
import com.mouse.maps.maps.data.MapRepository;
import com.mouse.maps.maps.mappers.MapProfile;
import com.mouse.maps.maps.models.GetMapsByUserRequest;
import com.mouse.maps.maps.models.GetMapsRequest;
import com.mouse.maps.maps.models.Map;
import com.mouse.maps.maps.queries.GetMaps;
import com.mouse.maps.maps.queries.GetMapsByUser;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Component
public class GetMapsQuery implements GetMaps {

    @Autowired
    protected MapRepository mapRepository;

    @Autowired
    protected MapProfile mapProfile;

    @Transactional
    public Collection<Map> invoke(GetMapsRequest request) {
        return this.mapRepository
            .findAll(Paginate.getPageRequest(request))
            .stream()
            .map(mapProfile::toMapFromMapEntity)
            .collect(Collectors.toList());
    }
}

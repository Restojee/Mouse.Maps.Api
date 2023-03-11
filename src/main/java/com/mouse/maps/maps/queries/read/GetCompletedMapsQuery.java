package com.mouse.maps.maps.queries.read;

import jakarta.transaction.Transactional;
import com.mouse.maps.common.Paginate;
import com.mouse.maps.maps.queries.GetCompletedMapsByUser;
import com.mouse.maps.maps.data.MapRepository;
import com.mouse.maps.maps.mappers.MapProfile;
import com.mouse.maps.maps.models.GetMapsByUserRequest;
import com.mouse.maps.maps.models.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Component
public class GetCompletedMapsQuery implements GetCompletedMapsByUser {

    @Autowired
    protected MapRepository mapRepository;

    @Autowired
    protected MapProfile mapProfile;

    @Transactional
    public Collection<Map> invoke(GetMapsByUserRequest getCompletedMapsRequest) {
        return this.mapRepository
            .findAllByCompleted_UserId(
                getCompletedMapsRequest.getUserId(),
                Paginate.getPageRequest(getCompletedMapsRequest)
            )
            .map(mapProfile::toMapFromMapEntity)
            .collect(Collectors.toList());
    }
}

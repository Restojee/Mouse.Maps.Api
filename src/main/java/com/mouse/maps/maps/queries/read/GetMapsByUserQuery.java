package com.mouse.maps.maps.queries.read;

import jakarta.transaction.Transactional;
import com.mouse.maps.maps.queries.GetMapsByUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.mouse.maps.common.Paginate;
import com.mouse.maps.maps.models.GetMapsByUserRequest;
import com.mouse.maps.maps.models.Map;

import com.mouse.maps.maps.mappers.MapProfile;
import com.mouse.maps.maps.data.MapRepository;

import java.util.Collection;
import java.util.stream.Collectors;

@Component
public class GetMapsByUserQuery implements GetMapsByUser {

    @Autowired
    protected MapRepository mapRepository;

    @Autowired
    protected MapProfile mapProfile;

    @Transactional
    public Collection<Map> invoke(GetMapsByUserRequest getMapsRequest) {
        return this.mapRepository
            .findAllByUser_Id(
                getMapsRequest.getUserId(),
                Paginate.getPageRequest(getMapsRequest)
            )
            .map(mapProfile::toMapFromMapEntity)
            .collect(Collectors.toList());
    }
}

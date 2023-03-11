package com.mouse.maps.maps.queries.read;

import jakarta.transaction.Transactional;
import com.mouse.maps.common.Paginate;
import com.mouse.maps.maps.queries.GetFavoriteMapsByUser;
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
public class GetFavoriteMapsQuery implements GetFavoriteMapsByUser {

    @Autowired
    private MapRepository mapRepository;

    @Autowired
    private MapProfile mapProfile;

    @Transactional
    public Collection<Map> invoke(GetMapsByUserRequest request) {
        return this.mapRepository
            .findAllByFavorites_UserId(
                request.getUserId(),
                Paginate.getPageRequest(request)
            )
            .map((mapProfile::toMapFromMapEntity))
            .collect(Collectors.toList());
    }
}

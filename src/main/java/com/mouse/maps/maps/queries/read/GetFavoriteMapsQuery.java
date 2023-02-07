package com.mouse.maps.maps.queries.read;

import jakarta.transaction.Transactional;
import com.mouse.maps.common.Paginate;
import com.mouse.maps.maps.queries.GetFavoriteMapsByUser;
import com.mouse.maps.maps.data.MapRepository;
import com.mouse.maps.maps.mappers.MapProfile;
import com.mouse.maps.maps.models.GetMapsRequest;
import com.mouse.maps.maps.models.Map;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class GetFavoriteMapsQuery implements GetFavoriteMapsByUser {
    private final MapRepository mapRepository;

    private final MapProfile mapProfile;

    public GetFavoriteMapsQuery(MapProfile mapProfile, MapRepository mapRepository) {
        this.mapProfile = mapProfile;
        this.mapRepository = mapRepository;
    }

    @Transactional
    public Collection<Map> invoke(GetMapsRequest request) {
        return this.mapRepository
            .findAllByFavorites_UserId(
                request.getUserId(),
                Paginate.getPageRequest(request)
            )
            .map((mapProfile::toMapFromMapEntity))
            .collect(Collectors.toList());
    }
}

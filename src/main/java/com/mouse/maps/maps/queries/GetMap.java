package com.mouse.maps.maps.queries;

import com.mouse.maps.maps.models.Map;

public interface GetMap {
    Map invoke(Integer mapId);
}

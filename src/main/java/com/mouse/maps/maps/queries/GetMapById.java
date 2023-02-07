package com.mouse.maps.maps.queries;

import com.mouse.maps.maps.models.Map;

public interface GetMapById {
    Map invoke(Integer mapId);
}

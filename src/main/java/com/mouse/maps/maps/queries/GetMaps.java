package com.mouse.maps.maps.queries;

import com.mouse.maps.maps.models.GetMapsRequest;
import com.mouse.maps.maps.models.Map;

import java.util.Collection;

public interface GetMaps {
    public Collection<Map> invoke(GetMapsRequest getMapsRequest);
}

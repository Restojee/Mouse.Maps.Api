package com.mouse.maps.maps.queries;

import com.mouse.maps.maps.models.Map;
import com.mouse.maps.maps.models.UpdateMapRequest;

public interface UpdateMap {
    public Map invoke(UpdateMapRequest request);
}

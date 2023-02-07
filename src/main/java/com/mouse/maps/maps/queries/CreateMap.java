package com.mouse.maps.maps.queries;

import com.mouse.maps.maps.models.CreateMapRequest;
import com.mouse.maps.maps.models.Map;

public interface CreateMap {
    public Map invoke(CreateMapRequest request);
}

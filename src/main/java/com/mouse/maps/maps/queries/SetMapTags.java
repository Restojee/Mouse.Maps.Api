package com.mouse.maps.maps.queries;

import com.mouse.maps.maps.models.Map;
import com.mouse.maps.maps.models.SetMapTagRequest;

public interface SetMapTags {
    public Map invoke(SetMapTagRequest request);
}

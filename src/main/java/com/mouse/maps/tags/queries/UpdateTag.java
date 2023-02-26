package com.mouse.maps.tags.queries;

import com.mouse.maps.tags.models.Tag;
import com.mouse.maps.tags.models.UpdateTagRequest;

public interface UpdateTag {
    public Tag invoke(UpdateTagRequest request);
}

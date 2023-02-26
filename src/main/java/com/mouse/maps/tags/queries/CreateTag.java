package com.mouse.maps.tags.queries;

import com.mouse.maps.tags.models.CreateTagRequest;
import com.mouse.maps.tags.models.Tag;

public interface CreateTag {
    public Tag invoke(CreateTagRequest request);
}

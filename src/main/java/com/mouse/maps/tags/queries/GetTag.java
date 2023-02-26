package com.mouse.maps.tags.queries;

import com.mouse.maps.tags.models.Tag;

public interface GetTag {
    public Tag invoke(Integer tagId);
}

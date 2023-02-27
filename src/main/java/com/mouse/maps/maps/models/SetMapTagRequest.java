package com.mouse.maps.maps.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

import java.util.Collection;

@Getter
@Setter
public class SetMapTagRequest {
    public Integer mapId;

    @Nullable
    public Collection<Integer> tagIds;
}

package com.mouse.maps.tags.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateTagRequest {
    public Integer tagId;

    public String name;

    public String description;
}

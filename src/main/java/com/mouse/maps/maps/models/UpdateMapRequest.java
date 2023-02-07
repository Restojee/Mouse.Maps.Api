package com.mouse.maps.maps.models;


import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

@Setter
@Getter
public class UpdateMapRequest {

    private Integer id;

    @Nullable
    private String name;

    @Nullable
    private String description;
}

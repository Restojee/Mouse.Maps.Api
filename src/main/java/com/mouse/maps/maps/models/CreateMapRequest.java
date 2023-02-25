package com.mouse.maps.maps.models;


import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

@Getter
@Setter
public class CreateMapRequest {

    public String name;

    @Nullable
    public String description;

}


package com.mouse.maps.maps.models;


import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

@Setter
@Getter
public class Map {

    public Integer id;

    public String name;
    
    @Nullable
    public String description;
}
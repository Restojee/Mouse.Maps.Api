package com.mouse.maps.maps.models;


import com.mouse.maps.users.models.User;
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

    @Nullable
    public User user;
}
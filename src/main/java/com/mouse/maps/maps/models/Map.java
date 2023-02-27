package com.mouse.maps.maps.models;


import com.mouse.maps.tags.models.Tag;
import com.mouse.maps.users.models.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

import java.util.Collection;

@Setter
@Getter
public class Map {

    public Integer id;

    public String name;
    
    @Nullable
    public String description;

    @Nullable
    public User user;

    @Nullable
    Collection<Tag> tags;
}
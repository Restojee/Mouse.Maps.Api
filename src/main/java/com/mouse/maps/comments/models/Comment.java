package com.mouse.maps.comments.models;

import com.mouse.maps.users.models.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

@Setter
@Getter
public class Comment {

    public Integer id;

    public String text;

    @Nullable
    public User user;
}

package com.mouse.maps.tips.models;

import com.mouse.maps.users.models.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

@Getter
@Setter
public class Tip {
    public Integer id;

    public String title;

    public String text;

    public User user;
}

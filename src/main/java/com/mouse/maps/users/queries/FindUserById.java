package com.mouse.maps.users.queries;

import com.mouse.maps.users.models.User;

public interface FindUserById {
    public User invoke(Integer userId);
}

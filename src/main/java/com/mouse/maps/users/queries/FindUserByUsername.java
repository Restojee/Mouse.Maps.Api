package com.mouse.maps.users.queries;

import com.mouse.maps.users.models.User;

public interface FindUserByUsername {
    public User invoke(String username);
}

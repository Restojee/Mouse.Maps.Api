package com.mouse.maps.users.queries;

import com.mouse.maps.users.models.User;

public interface FindOrCreateUser {
    public User invoke(String username);
}

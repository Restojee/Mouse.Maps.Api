package com.mouse.maps.users.queries.read;

import com.mouse.maps.users.mappers.UserProfile;
import com.mouse.maps.users.models.User;
import com.mouse.maps.users.queries.FindCurrentUser;
import com.mouse.maps.users.services.UserService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class FindCurrentUserQuery implements FindCurrentUser {

    @Autowired
    protected UserService userService;

    @Autowired
    protected UserProfile userProfile;

    public User invoke() {
        val authentication = SecurityContextHolder
            .getContext()
            .getAuthentication();
        return this.userProfile.toUserFromUserDetails(
            this.userService.loadUserByUsername(authentication.getName())
        );
    }
}

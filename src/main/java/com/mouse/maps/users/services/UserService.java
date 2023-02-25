package com.mouse.maps.users.services;

import com.mouse.maps.users.mappers.UserProfile;
import com.mouse.maps.users.models.UserDetails;
import com.mouse.maps.users.queries.FindOrCreateUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    protected FindOrCreateUser findOrCreateUser;

    @Autowired UserProfile userProfile;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.userProfile.toUserDetailsFromUser(
            this.findOrCreateUser.invoke(username)
        );
    }
}

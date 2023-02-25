package com.mouse.maps.users.services;

import com.mouse.maps.users.queries.FindOrCreateUser;
import lombok.val;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserService implements UserDetailsService {
    protected FindOrCreateUser findOrCreateUser;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        val user = this.findOrCreateUser.invoke(username);

        return new User(
            user.getUsername(),
            null,
            Collections.emptyList()
        );
    }
}

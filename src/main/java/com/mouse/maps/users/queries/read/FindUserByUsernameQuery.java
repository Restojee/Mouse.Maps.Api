package com.mouse.maps.users.queries.read;

import com.mouse.maps.users.data.UserRepository;
import com.mouse.maps.users.mappers.UserProfile;
import com.mouse.maps.users.models.User;
import com.mouse.maps.users.queries.FindUserByUsername;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindUserByUsernameQuery implements FindUserByUsername {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserProfile userProfile;

    public User invoke(String username) {
        val foundUser = this.userRepository.findByUsername(username);

        return foundUser
            .map(userEntity -> userProfile.toUserFromUserEntity(userEntity))
            .orElse(null);

    }
}

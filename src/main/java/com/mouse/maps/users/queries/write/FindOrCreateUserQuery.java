package com.mouse.maps.users.queries.write;

import com.mouse.maps.entities.UserEntity;
import com.mouse.maps.users.data.UserRepository;
import com.mouse.maps.users.mappers.UserProfile;
import com.mouse.maps.users.models.User;
import com.mouse.maps.users.queries.FindOrCreateUser;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindOrCreateUserQuery implements FindOrCreateUser {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserProfile userProfile;

    public User invoke(String username) {
        val foundUser = this.userRepository.findByUsername(username);

        if (foundUser.isPresent()) {
            return userProfile.toUserFromUserEntity(foundUser.get());
        }

        val createUserRequest = UserEntity.builder().username(username).build();

        return userProfile.toUserFromUserEntity(
            this.userRepository.save(createUserRequest)
        );
    }
}

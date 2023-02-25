package com.mouse.maps.users.queries.read;

import com.mouse.maps.users.data.UserRepository;
import com.mouse.maps.users.mappers.UserProfile;
import com.mouse.maps.users.models.User;
import com.mouse.maps.users.queries.FindUserById;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindUserByIdQuery implements FindUserById {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserProfile userProfile;

    public User invoke(Integer userId) {
        val foundUser = this.userRepository.findById(userId);

        return foundUser
            .map(userEntity -> userProfile.toUserFromUserEntity(userEntity))
            .orElse(null);

    }
}

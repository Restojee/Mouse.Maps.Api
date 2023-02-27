package com.mouse.maps.users.mappers;

import com.mouse.maps.entities.UserEntity;
import com.mouse.maps.users.models.JwtRequest;
import com.mouse.maps.users.models.User;
import com.mouse.maps.users.models.UserDetails;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
    componentModel = "spring",
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface UserProfile {

    User toUserFromUserEntity(UserEntity userEntity);

    UserEntity toUserEntityFromUser(User user);

    UserEntity toUserEntityFromUserLoginRequest(JwtRequest loginRequest);

    UserDetails toUserDetailsFromUser(User user);

    User toUserFromUserDetails(UserDetails userDetails);

    //UserEntity toUserEntityFromRegisterUserRequest(RegisterUserRequest registerUserRequest);
}

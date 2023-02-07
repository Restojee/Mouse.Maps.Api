package com.mouse.maps.users.mappers;



import com.mouse.maps.entities.UserEntity;
import com.mouse.maps.users.models.JwtRequest;
import com.mouse.maps.users.models.User;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface UserProfile {

    User toUserFromUserEntity(UserEntity userEntity);

    UserEntity toUserEntityFromUser(User user);

    UserEntity toUserEntityFromUserLoginRequest(JwtRequest loginRequest);

    //UserEntity toUserEntityFromRegisterUserRequest(RegisterUserRequest registerUserRequest);
}

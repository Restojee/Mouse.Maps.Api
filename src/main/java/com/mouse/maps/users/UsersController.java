package com.mouse.maps.users;

import com.mouse.maps.users.models.User;
import com.mouse.maps.users.queries.read.FindUserByUsernameQuery;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/users")
@SecurityRequirement(name = "bearerAuth")
@PreAuthorize("isAuthenticated()")
@Tag(name = "Users")
@RestController
public class UsersController {

    @Autowired
    private FindUserByUsernameQuery findUserByUsername;

    @GetMapping("/current")
    @Operation(
        description = "GetCurrentUser",
        security = @SecurityRequirement(name = "bearerAuth")
    )
    public User getCurrentUser(Authentication authentication) {
        return this.findUserByUsername.invoke(authentication.getName());
    }
}

package com.mouse.maps.favorite;

import com.mouse.maps.favorite.models.CreateFavoriteRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/favorite")
@SecurityRequirement(name = "bearerAuth")
@PreAuthorize("isAuthenticated()")
@Tag(name = "Favorite")
@RestController
public class FavoriteController {

    @PostMapping
    @Operation(
        description = "Create favorite endpoint",
        security = @SecurityRequirement(name = "bearerAuth")
    )
    public String createFavorite(@ParameterObject CreateFavoriteRequest request) {
        return "Ok";
    }

    @DeleteMapping
    @Operation(
        description = "Remove favorite endpoint",
        security = @SecurityRequirement(name = "bearerAuth")
    )
    public String removeFavorite(@ParameterObject Integer favoriteId) {
        return "Ok";
    }

}

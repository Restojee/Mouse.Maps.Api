package com.mouse.maps.completed;

import com.mouse.maps.completed.models.GetCompletedRequest;
import com.mouse.maps.completed.models.UpdateCompletedRequest;
import com.mouse.maps.maps.models.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/completed")
@SecurityRequirement(name = "bearerAuth")
@PreAuthorize("isAuthenticated()")
@Tag(name = "Completed")
@RestController
public class CompletedController {

    @GetMapping("/by-map")
    @Operation(
        description = "Get completed by map endpoint",
        security = @SecurityRequirement(name = "bearerAuth")
    )
    public String getCompletedByMap(@ParameterObject GetCompletedRequest request) {
        return "Ok";
    }

    @GetMapping("/by-user")
    @Operation(
        description = "Get completed by user endpoint",
        security = @SecurityRequirement(name = "bearerAuth")
    )
    public String getCompletedByUser(@ParameterObject GetCompletedRequest request) {
        return "Ok";
    }

    @PutMapping
    @Operation(
        description = "Remove completed endpoint",
        security = @SecurityRequirement(name = "bearerAuth")
    )
    public String createCompleted(@ParameterObject UpdateCompletedRequest request) {
        return "Ok";
    }

    @DeleteMapping
    @Operation(
        description = "Create completed endpoint",
        security = @SecurityRequirement(name = "bearerAuth")
    )
    public String removeCompleted(@ParameterObject Integer completedId) {
        return "Ok";
    }

}

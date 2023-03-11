package com.mouse.maps.info;

import com.mouse.maps.info.models.GetInfoRequest;
import com.mouse.maps.info.models.UpdateInfoRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/info")
@SecurityRequirement(name = "bearerAuth")
@PreAuthorize("isAuthenticated()")
@Tag(name = "Info")
@RestController
public class InfoController {

    @GetMapping
    @Operation(
        description = "Get info paginate endpoint",
        security = @SecurityRequirement(name = "bearerAuth")
    )
    public String getInfoPaginate(@ParameterObject GetInfoRequest request) {
        return "Ok";
    }

    @PostMapping
    @Operation(
        description = "Update info endpoint",
        security = @SecurityRequirement(name = "bearerAuth")
    )
    public String createInfo(@ParameterObject UpdateInfoRequest request) {
        return "Ok";
    }

    @PutMapping
    @Operation(
        description = "Remove info endpoint",
        security = @SecurityRequirement(name = "bearerAuth")
    )
    public String updateInfo(@ParameterObject UpdateInfoRequest request) {
        return "Ok";
    }

    @DeleteMapping
    @Operation(
        description = "Create info endpoint",
        security = @SecurityRequirement(name = "bearerAuth")
    )
    public String removeInfo(@ParameterObject Integer infoId) {
        return "Ok";
    }

}

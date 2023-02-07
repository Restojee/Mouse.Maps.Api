package com.mouse.maps.maps;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import com.mouse.maps.maps.models.UpdateMapRequest;
import com.mouse.maps.maps.queries.read.GetCompletedMapsQuery;
import com.mouse.maps.maps.queries.read.GetFavoriteMapsQuery;
import com.mouse.maps.maps.queries.read.GetMapQuery;
import com.mouse.maps.maps.queries.read.GetMapsQuery;
import com.mouse.maps.maps.queries.write.CreateMapQuery;
import com.mouse.maps.maps.models.CreateMapRequest;
import com.mouse.maps.maps.models.GetMapsRequest;
import com.mouse.maps.maps.models.Map;
import com.mouse.maps.maps.queries.write.DeleteMapQuery;
import com.mouse.maps.maps.queries.write.UpdateMapQuery;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/maps")
@SecurityRequirement(name = "bearerAuth")
@PreAuthorize("isAuthenticated()")
@Tag(name = "Maps")
public class MapsController {

    @Autowired
    private CreateMapQuery createMapQuery;

    @Autowired
    private GetMapQuery getMapQuery;

    @Autowired
    private GetMapsQuery getMapsQuery;

    @Autowired
    private GetFavoriteMapsQuery getFavoriteMapsQuery;

    @Autowired
    private GetCompletedMapsQuery getCompletedMapsQuery;

    @Autowired
    private UpdateMapQuery updateMapQuery;

    @Autowired
    private DeleteMapQuery deleteMapQuery;


    @GetMapping
    @Operation(
        description = "GetMaps",
        security = @SecurityRequirement(name = "bearerAuth")
    )
    public Collection<Map> getMaps(@ParameterObject GetMapsRequest request) {
        return this.getMapsQuery.invoke(request);
    }

    @GetMapping("/{mapId}")
    @Operation(
        description = "Get map endpoint",
        security = @SecurityRequirement(name = "bearerAuth")
    )
    public Map getMap(@PathVariable Integer mapId) {
        return this.getMapQuery.invoke(mapId);
    }

    @GetMapping("/favorites")
    @Operation(
        description = "Get favorite maps endpoint",
        security = @SecurityRequirement(name = "bearerAuth")
    )
    public Collection<Map> getFavoriteMaps(@ParameterObject GetMapsRequest request) {
        return this.getFavoriteMapsQuery.invoke(request);
    }

    @GetMapping("/completed")
    @Operation(
        description = "Get completed maps endpoint",
        security = @SecurityRequirement(name = "bearerAuth")
    )
    public Collection<Map> getCompletedMapsByUser(@ParameterObject GetMapsRequest request) {
        return this.getCompletedMapsQuery.invoke(request);
    }

    @PostMapping("/maps")
    @Operation(
        description = "Create map endpoint",
        security = @SecurityRequirement(name = "bearerAuth")
    )
    public Map createMap(@ParameterObject CreateMapRequest request) {
        return this.createMapQuery.invoke(request);
    }

    @PutMapping("/maps")
    @Operation(
        description = "Update map endpoint",
        security = @SecurityRequirement(name = "bearerAuth")
    )
    public Map createMap(@ParameterObject UpdateMapRequest request) {
        return this.updateMapQuery.invoke(request);
    }

    @DeleteMapping("/maps")
    @Operation(
        description = "Delete map endpoint",
        security = @SecurityRequirement(name = "bearerAuth")
    )
    public String deleteMap(@ParameterObject Integer mapId) {
        this.deleteMapQuery.invoke(mapId);
        return "Ok";
    }
}

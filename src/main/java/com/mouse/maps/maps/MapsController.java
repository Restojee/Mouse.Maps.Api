package com.mouse.maps.maps;

import com.mouse.maps.maps.queries.*;
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
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RequestMapping("/maps")
@SecurityRequirement(name = "bearerAuth")
@PreAuthorize("isAuthenticated()")
@Tag(name = "Maps")
@RestController
public class MapsController {

    @Autowired
    private CreateMap createMap;

    @Autowired
    private GetMap getMap;

    @Autowired
    private GetMapsByUser getMapsByUser;

    @Autowired
    private GetFavoriteMapsByUser getFavoriteMapsByUser;

    @Autowired
    private GetCompletedMapsByUser getCompletedMapsByUser;

    @Autowired
    private UpdateMap updateMap;

    @Autowired
    private DeleteMap deleteMap;

    @GetMapping
    @Operation(
        description = "GetMaps",
        security = @SecurityRequirement(name = "bearerAuth")
    )
    public Collection<Map> getMaps(@ParameterObject GetMapsRequest request) {
        return this.getMapsByUser.invoke(request);
    }

    @GetMapping("/{mapId}")
    @Operation(
        description = "Get map endpoint",
        security = @SecurityRequirement(name = "bearerAuth")
    )
    public Map getMap(@PathVariable Integer mapId) {
        return this.getMap.invoke(mapId);
    }

    @GetMapping("/favorites")
    @Operation(
        description = "Get favorite maps endpoint",
        security = @SecurityRequirement(name = "bearerAuth")
    )
    public Collection<Map> getFavoriteMaps(@ParameterObject GetMapsRequest request) {
        return this.getFavoriteMapsByUser.invoke(request);
    }

    @GetMapping("/completed")
    @Operation(
        description = "Get completed maps endpoint",
        security = @SecurityRequirement(name = "bearerAuth")
    )
    public Collection<Map> getCompletedMapsByUser(@ParameterObject GetMapsRequest request) {
        return this.getCompletedMapsByUser.invoke(request);
    }

    @PostMapping
    @Operation(
        description = "Create map endpoint",
        security = @SecurityRequirement(name = "bearerAuth")
    )
    public Map createMap(@ParameterObject CreateMapRequest request) {
        return this.createMap.invoke(request);
    }

    @PutMapping
    @Operation(
        description = "Update map endpoint",
        security = @SecurityRequirement(name = "bearerAuth")
    )
    public Map createMap(@ParameterObject UpdateMapRequest request) {
        return this.updateMap.invoke(request);
    }

    @DeleteMapping
    @Operation(
        description = "Delete map endpoint",
        security = @SecurityRequirement(name = "bearerAuth")
    )
    public String deleteMap(@ParameterObject Integer mapId) {
        this.deleteMap.invoke(mapId);
        return "Ok";
    }
}

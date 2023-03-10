package com.mouse.maps.maps;

import com.mouse.maps.maps.models.*;
import com.mouse.maps.maps.queries.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    @Autowired
    private SetMapTags setMapTags;

    @Autowired
    private UploadMapImage uploadMapImage;

    @GetMapping
    @Operation(
        description = "Get maps endpoint",
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
        description = "Get favorite maps by user endpoint",
        security = @SecurityRequirement(name = "bearerAuth")
    )
    public Collection<Map> getFavoriteMapsByUser(@ParameterObject GetMapsRequest request) {
        return this.getFavoriteMapsByUser.invoke(request);
    }

    @GetMapping("/completed")
    @Operation(
        description = "Get completed maps by user endpoint",
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
    public Map updateMap(@ParameterObject UpdateMapRequest request) {
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

    @PutMapping("/set-tags")
    @Operation(
        description = "Set map tags endpoint",
        security = @SecurityRequirement(name = "bearerAuth")
    )
    public Map setMapTags(@ParameterObject SetMapTagRequest request) {
        return this.setMapTags.invoke(request);
    }

    @PutMapping(value = "/update-image/{mapId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Operation(
        description = "Update map image",
        security = @SecurityRequirement(name = "bearerAuth")
    )
    public Map updateMapImage(@RequestParam("file") MultipartFile file, @PathVariable Integer mapId) {
        return this.uploadMapImage.invoke(file, mapId);
    }
}

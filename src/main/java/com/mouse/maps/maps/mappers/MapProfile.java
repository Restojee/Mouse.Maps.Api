package com.mouse.maps.maps.mappers;

import com.mouse.maps.entities.MapCompletedEntity;
import com.mouse.maps.entities.MapEntity;
import com.mouse.maps.entities.MapFavoriteEntity;
import com.mouse.maps.maps.models.*;
import com.mouse.maps.maps.models.CompleteMapRequest;
import com.mouse.maps.maps.models.FavoriteMapsRequest;
import com.mouse.maps.maps.models.UpdateMapImageRequest;
import com.mouse.maps.tags.mappers.TagProfile;
import org.mapstruct.*;

@Mapper(
    uses = TagProfile.class,
    componentModel = "spring",
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface MapProfile {

    @Mapping(target = "user", source = "user")
    @Mapping(source = "tags", target = "tags")
    Map toMapFromMapEntity(MapEntity mapEntity);

    MapEntity toMapEntityFromCreateMapRequest(
        CreateMapRequest createMapRequest
    );

    MapCompletedEntity toMapCompletedEntityFromCompleteRequest(
        CompleteMapRequest completeMapRequest
    );

    MapFavoriteEntity toMapFavoriteEntityFromFavoriteRequest(
        FavoriteMapsRequest favoriteMapRequest
    );

    MapEntity toMapEntityFromUpdateMapRequest(
        @MappingTarget MapEntity mapEntity,
        UpdateMapRequest updateMapRequest
    );

    MapEntity toMapEntityFromMapUpdateRequest(
        @MappingTarget MapEntity mapEntity,
        UpdateMapRequest updateMapRequest
    );

    MapEntity toMapEntityFromMapUpdateImageRequest(
        @MappingTarget MapEntity mapEntity,
        UpdateMapImageRequest updateMapImageRequest
    );
}

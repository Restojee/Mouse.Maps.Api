package com.mouse.maps.maps.mappers;

import com.mouse.maps.entities.MapCompletedEntity;
import com.mouse.maps.entities.MapEntity;
import com.mouse.maps.entities.MapFavoriteEntity;
import com.mouse.maps.maps.models.*;
import com.mouse.maps.maps.models.CompleteMapRequest;
import com.mouse.maps.maps.models.FavoriteMapsRequest;
import com.mouse.maps.maps.models.UpdateMapImageRequest;
import org.mapstruct.*;

import java.util.Collection;
import java.util.stream.Stream;

@Mapper(
    componentModel = "spring",
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE

)
public interface MapProfile {

    @Mapping(target = "user", source = "user")
    Map toMapFromMapEntity(MapEntity mapEntity);

    @Mapping(target = "user", source = "user")
    MapEntity toMapEntityFromMap(Map map);

    @Mapping(target = "user.id", source = "userId")
    MapEntity toMapEntityFromCreateMapRequest(CreateMapRequest createMapRequest);

    MapEntity toMapEntityFromUpdateMapRequest(@MappingTarget MapEntity mapEntity, UpdateMapRequest updateMapRequest);

    MapCompletedEntity toMapCompletedEntityFromCompleteRequest(CompleteMapRequest completeMapRequest);

    MapFavoriteEntity toMapFavoriteEntityFromFavoriteRequest(FavoriteMapsRequest favoriteMapRequest);

    MapEntity toMapEntityFromMapUpdateRequest(@MappingTarget MapEntity mapEntity, UpdateMapRequest updateMapRequest);

    MapEntity toMapEntityFromMapUpdateImageRequest(@MappingTarget MapEntity mapEntity, UpdateMapImageRequest updateMapImageRequest);
}

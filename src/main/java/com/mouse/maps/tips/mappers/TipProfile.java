package com.mouse.maps.tips.mappers;

import com.mouse.maps.entities.TipEntity;
import com.mouse.maps.tips.models.CreateTipRequest;
import com.mouse.maps.tips.models.Tip;
import com.mouse.maps.tips.models.UpdateTipRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
    componentModel = "spring",
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface TipProfile {
    @Mapping(target = "user", source = "user")
    public Tip toTipFromTipEntity(TipEntity tipEntity);

    public TipEntity toTipEntityFromCreateTipRequest(CreateTipRequest request);

    @Mapping(target = "id", source = "tipId")
    public TipEntity toTipEntityFromUpdateTipRequest(@MappingTarget TipEntity tipEntity, UpdateTipRequest request);
}

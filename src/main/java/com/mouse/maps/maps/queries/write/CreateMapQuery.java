package com.mouse.maps.maps.queries.write;

import com.mouse.maps.exceptions.BadRequestException;
import com.mouse.maps.maps.queries.CreateMap;
import com.mouse.maps.maps.data.MapRepository;
import com.mouse.maps.maps.mappers.MapProfile;
import com.mouse.maps.maps.models.CreateMapRequest;
import com.mouse.maps.maps.models.Map;
import com.mouse.maps.users.queries.FindUserById;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateMapQuery implements CreateMap {
    @Autowired
    protected MapRepository mapRepository;

    @Autowired
    protected MapProfile mapProfile;

    @Autowired
    protected FindUserById findUserById;

    public Map invoke(CreateMapRequest request) {
        val user = this.findUserById.invoke(request.userId);
        if (user == null) {
            throw new BadRequestException("Пользователь с таким идентификатором не найден");
        }
        return this.mapProfile.toMapFromMapEntity(
           this.mapRepository.save(this.mapProfile.toMapEntityFromCreateMapRequest(request))
        );
    }
}

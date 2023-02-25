package com.mouse.maps.maps.queries.write;

import com.mouse.maps.maps.queries.CreateMap;
import com.mouse.maps.maps.data.MapRepository;
import com.mouse.maps.maps.mappers.MapProfile;
import com.mouse.maps.maps.models.CreateMapRequest;
import com.mouse.maps.maps.models.Map;
import com.mouse.maps.users.queries.read.FindUserByIdQuery;
import lombok.val;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CreateMapQuery implements CreateMap {
    protected MapRepository mapRepository;

    protected MapProfile mapProfile;

    protected FindUserByIdQuery findUserById;

    public Map invoke(CreateMapRequest request) {
        val user = this.findUserById.invoke(request.userId);
        if (user == null) {
            throw new UsernameNotFoundException("Пользователь с таким идентификатором не найден");
        }
        return this.mapProfile.toMapFromMapEntity(
           this.mapRepository.save(this.mapProfile.toMapEntityFromCreateMapRequest(request))
        );
    }
}

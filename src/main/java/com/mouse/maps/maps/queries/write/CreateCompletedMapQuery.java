package com.mouse.maps.maps.queries.write;

import com.mouse.maps.entities.MapCompletedEntity;
import com.mouse.maps.entities.UserEntity;
import com.mouse.maps.exceptions.BadRequestException;
import com.mouse.maps.maps.data.MapCompletedRepository;
import com.mouse.maps.maps.data.MapRepository;
import com.mouse.maps.maps.queries.CreateCompletedMap;
import com.mouse.maps.services.FileService;
import com.mouse.maps.users.queries.FindCurrentUser;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class CreateCompletedMapQuery implements CreateCompletedMap {
    @Autowired
    public MapRepository mapRepository;

    @Autowired
    public MapCompletedRepository mapCompletedRepository;

    @Autowired
    public FindCurrentUser findCurrentUser;

    @Autowired
    public FileService fileService;

    public void invoke(Integer mapId, MultipartFile file) {

        val foundMap = this.mapRepository.findById(mapId);

        if (!foundMap.isPresent()) {
            throw new BadRequestException("Запрашиваемая карта не найдена");
        }

        val currentUserId = this.findCurrentUser.invoke().getId();

        val foundCompleted = mapCompletedRepository.findByUserIdAndMapId(currentUserId, mapId);

        if (foundCompleted.isPresent()) {
            throw new BadRequestException("Запрашиваемая карта уже добавлена в избранное этого пользователя");
        }

        this.mapCompletedRepository.save(
            MapCompletedEntity.builder()
                .map(foundMap.get())
                .user(UserEntity
                    .builder()
                    .id(this.findCurrentUser.invoke().getId())
                    .build())
                .image(this.fileService.upload(file))
                .build()
        );
    }

}

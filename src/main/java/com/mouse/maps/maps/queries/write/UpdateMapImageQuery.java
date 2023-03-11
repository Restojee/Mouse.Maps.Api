package com.mouse.maps.maps.queries.write;

import com.mouse.maps.exceptions.BadRequestException;
import com.mouse.maps.maps.data.MapRepository;
import com.mouse.maps.maps.mappers.MapProfile;
import com.mouse.maps.maps.models.Map;
import com.mouse.maps.maps.models.UpdateMapImageRequest;
import com.mouse.maps.maps.queries.UploadMapImage;
import com.mouse.maps.services.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;


@Component
public class UpdateMapImageQuery implements UploadMapImage {

    @Autowired
    private MapRepository mapRepository;

    @Autowired
    private MapProfile mapProfile;

    @Autowired
    private FileService fileService;

    @Override
    public Map invoke(MultipartFile file, Integer mapId) {
        return this.mapRepository
            .findById(mapId)
            .map(mapEntity -> {
                mapEntity.setImage(
                    this.fileService.upload(file)
                );

                return this.mapProfile.toMapFromMapEntity(
                    this.mapRepository.save(mapEntity)
                );
            })
            .orElseThrow(() -> new BadRequestException("Запрашиваемая карта не найдена"));

    }
}

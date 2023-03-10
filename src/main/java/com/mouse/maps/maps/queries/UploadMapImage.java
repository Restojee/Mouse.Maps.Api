package com.mouse.maps.maps.queries;

import com.mouse.maps.maps.models.Map;
import org.springframework.web.multipart.MultipartFile;


public interface UploadMapImage {
    public Map invoke(MultipartFile file, Integer mapId);
}

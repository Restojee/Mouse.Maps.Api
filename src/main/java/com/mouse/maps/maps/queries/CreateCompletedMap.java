package com.mouse.maps.maps.queries;

import org.springframework.web.multipart.MultipartFile;

public interface CreateCompletedMap {
    public void invoke(Integer mapId, MultipartFile file);
}

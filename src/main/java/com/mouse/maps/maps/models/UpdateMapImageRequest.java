package com.mouse.maps.maps.models;


import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateMapImageRequest {

    private Integer mapId;

    private MultipartFile imageFile;

}

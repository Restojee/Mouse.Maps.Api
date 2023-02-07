package com.mouse.maps.maps.models;


import lombok.Getter;
import lombok.Setter;

import java.io.File;

@Getter
@Setter
public class UpdateMapImageRequest {

    private Integer mapId;

    private File imageFile;

}

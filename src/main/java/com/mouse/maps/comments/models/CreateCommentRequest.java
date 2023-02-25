package com.mouse.maps.comments.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCommentRequest {
    public String text;

    public Integer mapId;
}

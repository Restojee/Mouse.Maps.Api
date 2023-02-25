package com.mouse.maps.comments.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateCommentRequest {
    public Integer commentId;

    public String text;
}

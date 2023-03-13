package com.mouse.maps.tips.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateTipRequest {
    public Integer tipId;

    public String title;

    public String text;
}

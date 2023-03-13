package com.mouse.maps.tips.queries;

import com.mouse.maps.tips.models.Tip;

public interface GetTip {
    public Tip invoke(Integer tipId);
}

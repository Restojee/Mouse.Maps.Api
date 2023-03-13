package com.mouse.maps.tips.queries;

import com.mouse.maps.tips.models.CreateTipRequest;
import com.mouse.maps.tips.models.Tip;

public interface CreateTip {
    public Tip invoke(CreateTipRequest request);
}

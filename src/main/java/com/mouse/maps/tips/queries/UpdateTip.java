package com.mouse.maps.tips.queries;

import com.mouse.maps.tips.models.Tip;
import com.mouse.maps.tips.models.UpdateTipRequest;

public interface UpdateTip {
    public Tip invoke(UpdateTipRequest request);
}

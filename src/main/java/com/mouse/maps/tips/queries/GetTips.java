package com.mouse.maps.tips.queries;

import com.mouse.maps.tips.models.Tip;

import java.util.Collection;

public interface GetTips {
    public Collection<Tip> invoke();
}

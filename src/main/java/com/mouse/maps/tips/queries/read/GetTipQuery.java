package com.mouse.maps.tips.queries.read;

import com.mouse.maps.exceptions.BadRequestException;
import com.mouse.maps.tips.data.TipRepository;
import com.mouse.maps.tips.mappers.TipProfile;
import com.mouse.maps.tips.models.Tip;
import com.mouse.maps.tips.queries.GetTip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetTipQuery implements GetTip {

    @Autowired
    protected TipRepository tipRepository;

    @Autowired
    protected TipProfile tipProfile;

    @Override
    public Tip invoke(Integer tipId) {
       return this.tipRepository.findById(tipId)
           .map(tipProfile::toTipFromTipEntity)
           .orElseThrow(() -> new BadRequestException("Тег с таким идентификатором не найден"));
    }
}

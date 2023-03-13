package com.mouse.maps.tips.queries.read;

import com.mouse.maps.tips.data.TipRepository;
import com.mouse.maps.tips.mappers.TipProfile;
import com.mouse.maps.tips.models.Tip;
import com.mouse.maps.tips.queries.GetTips;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.Collectors;

@Component
public class GetTipsQuery implements GetTips {

    @Autowired
    protected TipRepository tipRepository;

    @Autowired
    protected TipProfile tipProfile;

    @Override
    public Collection<Tip> invoke() {
        return this.tipRepository.findAll()
            .stream()
            .map(tipProfile::toTipFromTipEntity)
            .collect(Collectors.toList());
    }
}

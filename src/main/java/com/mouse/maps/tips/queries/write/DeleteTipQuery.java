package com.mouse.maps.tips.queries.write;

import com.mouse.maps.exceptions.BadRequestException;
import com.mouse.maps.tips.data.TipRepository;
import com.mouse.maps.tips.queries.DeleteTip;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteTipQuery implements DeleteTip {

    @Autowired
    protected TipRepository tipRepository;

    @Override
    public void invoke(Integer tipId) {
        val foundTip = this.tipRepository.findById(tipId);

        if (!foundTip.isPresent()) {
            throw new BadRequestException("Совет с указанным идентификатором не существует");
        }

        this.tipRepository.delete(foundTip.get());
    }
}

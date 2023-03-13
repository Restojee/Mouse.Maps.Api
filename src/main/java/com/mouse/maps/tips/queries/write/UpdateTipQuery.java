package com.mouse.maps.tips.queries.write;

import com.mouse.maps.exceptions.BadRequestException;
import com.mouse.maps.tips.data.TipRepository;
import com.mouse.maps.tips.mappers.TipProfile;
import com.mouse.maps.tips.models.Tip;
import com.mouse.maps.tips.models.UpdateTipRequest;
import com.mouse.maps.tips.queries.UpdateTip;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateTipQuery implements UpdateTip {

    @Autowired
    protected TipRepository tipRepository;

    @Autowired
    protected TipProfile tipProfile;

    @Override
    public Tip invoke(UpdateTipRequest request) {
        val foundTip = this.tipRepository.findById(request.tipId);

        if (!foundTip.isPresent()) {
            throw new BadRequestException("Совет  с указанным идентификатором не существует");
        }

        val payload = this.tipProfile.toTipEntityFromUpdateTipRequest(foundTip.get(), request);

        return this.tipProfile.toTipFromTipEntity(
            this.tipRepository.save(payload )
        );
    }
}

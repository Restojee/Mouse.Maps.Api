package com.mouse.maps.tips.queries.write;

import com.mouse.maps.entities.UserEntity;
import com.mouse.maps.exceptions.BadRequestException;
import com.mouse.maps.tips.data.TipRepository;
import com.mouse.maps.tips.mappers.TipProfile;
import com.mouse.maps.tips.models.CreateTipRequest;
import com.mouse.maps.tips.models.Tip;
import com.mouse.maps.tips.queries.CreateTip;
import com.mouse.maps.users.queries.FindCurrentUser;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

@Component
public class CreateTipQuery implements CreateTip {

    @Autowired
    protected TipRepository tipRepository;

    @Autowired
    protected TipProfile tipProfile;

    @Autowired
    protected FindCurrentUser findCurrentUser;

    @Override
    public Tip invoke(CreateTipRequest request) {

        val payload = this.tipProfile.toTipEntityFromCreateTipRequest(request);

        val user = findCurrentUser.invoke();

        payload.setUser(UserEntity.builder().id(user.id).build());

        return this.tipProfile.toTipFromTipEntity(
            this.tipRepository.save(payload)
        );
    }
}

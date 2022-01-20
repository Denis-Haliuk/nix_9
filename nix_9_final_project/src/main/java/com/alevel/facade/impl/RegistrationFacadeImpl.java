package com.alevel.facade.impl;

import com.alevel.facade.RegistrationFacade;
import com.alevel.persistence.entity.user.Personal;
import com.alevel.service.PersonalCrudService;
import com.alevel.web.dto.request.register.AuthDto;
import org.springframework.stereotype.Service;

@Service
public class RegistrationFacadeImpl implements RegistrationFacade {

    private final PersonalCrudService personalService;

    public RegistrationFacadeImpl(PersonalCrudService personalService) {
        this.personalService = personalService;
    }

    @Override
    public void registration(AuthDto dto) {
        Personal personal = new Personal();
        personal.setEmail(dto.getEmail());
        personal.setPassword(dto.getPassword());
        personalService.create(personal);
    }
}

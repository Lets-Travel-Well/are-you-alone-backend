package com.rualone.app.domain.journey.validator;

import com.rualone.app.domain.journey.dao.JourneyRepository;
import com.rualone.app.domain.journey.entity.Journey;
import com.rualone.app.global.error.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class JourneyValidator {
    private final JourneyRepository journeyRepository;
    public Journey findById(Long id){
        return journeyRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(Journey.class, id));
    }
}

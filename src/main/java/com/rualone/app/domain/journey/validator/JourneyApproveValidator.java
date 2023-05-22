package com.rualone.app.domain.journey.validator;

import com.rualone.app.domain.journey.dao.JourneyApproveRepository;
import com.rualone.app.domain.journey.entity.JourneyApprove;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class JourneyApproveValidator {
    private final JourneyApproveRepository journeyApproveRepository;
}

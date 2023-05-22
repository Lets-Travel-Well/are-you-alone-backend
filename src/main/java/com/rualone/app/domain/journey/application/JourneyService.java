package com.rualone.app.domain.journey.application;

import com.rualone.app.domain.journey.dto.request.JourneyCreateRequest;
import com.rualone.app.domain.member.entity.Member;

public interface JourneyService {
    void save(JourneyCreateRequest journeyCreateRequest, Member findMember);
}

package com.rualone.app.domain.journey.application;

import com.rualone.app.domain.journey.dto.request.JourneyAgreeRequest;
import com.rualone.app.domain.journey.dto.request.JourneyDisAgreeRequest;
import com.rualone.app.domain.journey.dto.request.JourneyJoinRequest;
import com.rualone.app.domain.member.entity.Member;

public interface JourneyApproveService {
    void save(JourneyJoinRequest journeyJoinRequest, Long memberId);

    void changeStatusAgree(JourneyAgreeRequest journeyAgreeRequest, Long leaderId);
    void changeStatusDisAgree(JourneyDisAgreeRequest journeyDisAgreeRequest, Long leaderId);

}

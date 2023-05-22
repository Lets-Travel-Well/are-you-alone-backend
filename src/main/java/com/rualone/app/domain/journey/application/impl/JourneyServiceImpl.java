package com.rualone.app.domain.journey.application.impl;

import com.rualone.app.domain.journey.application.JourneyService;
import com.rualone.app.domain.journey.dao.JourneyRepository;
import com.rualone.app.domain.journey.dto.request.JourneyCreateRequest;
import com.rualone.app.domain.journey.entity.Journey;
import com.rualone.app.domain.member.entity.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional
public class JourneyServiceImpl implements JourneyService {
    private final JourneyRepository journeyRepository;

    @Override
    public void save(JourneyCreateRequest journeyCreateRequest, Member findMember) {
        journeyRepository.save(journeyCreateRequest.toEntity(findMember));
    }
}

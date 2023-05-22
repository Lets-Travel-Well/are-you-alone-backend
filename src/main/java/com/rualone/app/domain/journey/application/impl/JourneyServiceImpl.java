package com.rualone.app.domain.journey.application.impl;

import com.rualone.app.domain.attraction.entity.AttractionInfo;
import com.rualone.app.domain.attraction.validator.AttractionInfoValidator;
import com.rualone.app.domain.journey.application.JourneyService;
import com.rualone.app.domain.journey.dao.JourneyPlaceRepository;
import com.rualone.app.domain.journey.dao.JourneyRepository;
import com.rualone.app.domain.journey.dto.request.AttractionInfoPathRequest;
import com.rualone.app.domain.journey.dto.request.JourneyCreateRequest;
import com.rualone.app.domain.journey.dto.request.JourneyPlaceCreateRequest;
import com.rualone.app.domain.journey.entity.Journey;
import com.rualone.app.domain.member.entity.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional
public class JourneyServiceImpl implements JourneyService {
    private final JourneyRepository journeyRepository;
    private final JourneyPlaceRepository journeyPlaceRepository;
    private final AttractionInfoValidator attractionInfoValidator;
    @Override
    public void save(JourneyCreateRequest journeyCreateRequest, Member findMember) {
        Journey saveJourney = journeyRepository.save(journeyCreateRequest.toEntity(findMember));
        List<JourneyPlaceCreateRequest> journeyPlaceCreateRequests = journeyCreateRequest.getJourneyPlaceCreateRequests();
        for(Integer i = 0; i < journeyPlaceCreateRequests.size(); i++){
            JourneyPlaceCreateRequest journeyPlaceCreateRequest = journeyPlaceCreateRequests.get(i);
            AttractionInfo attractionInfo = attractionInfoValidator.findByContentId(journeyPlaceCreateRequest.getContentId());
            journeyPlaceRepository.save(journeyPlaceCreateRequest.toEntity(attractionInfo, saveJourney, i));
        }
    }
}

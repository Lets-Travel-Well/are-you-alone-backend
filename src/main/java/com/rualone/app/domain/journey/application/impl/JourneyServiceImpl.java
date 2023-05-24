package com.rualone.app.domain.journey.application.impl;

import com.rualone.app.domain.attraction.entity.AttractionInfo;
import com.rualone.app.domain.attraction.validator.AttractionInfoValidator;
import com.rualone.app.domain.journey.application.JourneyService;
import com.rualone.app.domain.journey.dao.JourneyApproveRepository;
import com.rualone.app.domain.journey.dao.JourneyPlaceRepository;
import com.rualone.app.domain.journey.dao.JourneyRepository;
import com.rualone.app.domain.journey.dto.request.AttractionInfoPathRequest;
import com.rualone.app.domain.journey.dto.request.JourneyCreateRequest;
import com.rualone.app.domain.journey.dto.request.JourneyPlaceCreateRequest;
import com.rualone.app.domain.journey.entity.Journey;
import com.rualone.app.domain.journey.entity.JourneyApprove;
import com.rualone.app.domain.journey.entity.ParticipationStatus;
import com.rualone.app.domain.member.entity.Member;
import com.rualone.app.domain.member.validator.MemberValidator;
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
    private final JourneyApproveRepository journeyApproveRepository;
    private final AttractionInfoValidator attractionInfoValidator;
    private final MemberValidator memberValidator;
    @Override
    public void save(JourneyCreateRequest journeyCreateRequest, Long memberId) {
        Member findMember = memberValidator.findById(memberId);
        // 여행 계획 저장
        Journey saveJourney = journeyRepository.save(journeyCreateRequest.toEntity(findMember));
        // 여행 승인 저장
        journeyApproveRepository.save(JourneyApprove.builder()
                .participant(findMember)
                .journey(saveJourney)
                .status(ParticipationStatus.AGREE)
                .build());
        // 상세 여행 계획 저장
        List<JourneyPlaceCreateRequest> journeyPlaceCreateRequests = journeyCreateRequest.getJourneyPlaceCreateRequests();
        for(Integer i = 0; i < journeyPlaceCreateRequests.size(); i++){
            JourneyPlaceCreateRequest journeyPlaceCreateRequest = journeyPlaceCreateRequests.get(i);
            AttractionInfo attractionInfo = attractionInfoValidator.findByContentId(journeyPlaceCreateRequest.getContentId());
            journeyPlaceRepository.save(journeyPlaceCreateRequest.toEntity(attractionInfo, saveJourney, i));
        }
    }
}

package com.rualone.app.domain.journey.application.impl;

import com.rualone.app.domain.attraction.validator.AttractionInfoValidator;
import com.rualone.app.domain.journey.application.JourneyQueryService;
import com.rualone.app.domain.journey.dao.JourneyApproveRepository;
import com.rualone.app.domain.journey.dao.JourneyQueryRepository;
import com.rualone.app.domain.journey.dto.request.AttractionInfoPathRequest;
import com.rualone.app.domain.journey.dto.response.*;
import com.rualone.app.domain.journey.entity.JourneyApprove;
import com.rualone.app.domain.journey.entity.ParticipationStatus;
import com.rualone.app.global.util.MakeMapUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class JourneyQueryServiceImpl implements JourneyQueryService {
    private final AttractionInfoValidator attractionInfoValidator;
    private final JourneyQueryRepository journeyQueryRepository;
    private final JourneyApproveRepository journeyApproveRepository;

    // TODO: 2023-05-22 : 여기 있는게 맞는 로직인가?(CQRS)
    @Override
    public List<AttractionInfoPathResponse> findShortestPath(List<AttractionInfoPathRequest> attractionInfoPathRequests) {
        for(AttractionInfoPathRequest attractionInfoPathRequest : attractionInfoPathRequests){
            attractionInfoValidator.findByContentId(attractionInfoPathRequest.getContentId());
        }
        return MakeMapUtils.makeShortestPath(attractionInfoPathRequests);
    }

    @Override
    public List<JourneyResponse> findAll() {
        // TODO: 2023/05/24 : query 튜닝
        List<JourneyResponse> journeyResponses = journeyQueryRepository.findAll();
        journeyResponses.forEach(journeyResponse -> {
            journeyResponse.setTravelerCnt(journeyQueryRepository.findTravelerCnt(journeyResponse.getId()));
            journeyResponse.setImage(journeyQueryRepository.findImage(journeyResponse.getId()));
        });
        return journeyResponses;
    }

    @Override
    public JourneyDetailResponse findJourneyById(Long journeyId, Long memberId) {
        // TODO: 2023/05/24 : query 튜닝이 진짜진짜진짜 필요함 
        JourneyDetailResponse journeyDetailResponse = journeyQueryRepository.findJourneyById(journeyId, memberId);
        journeyDetailResponse.setTravelerCnt(journeyQueryRepository.findTravelerCnt(journeyId));
        journeyDetailResponse.setMyJourney(journeyQueryRepository.isMine(journeyId, memberId));
        journeyDetailResponse.setJourneyPlaceResponseList(journeyQueryRepository.findJourneyPlace(journeyId));
        journeyDetailResponse.setLeader(journeyQueryRepository.findLeaderInfo(journeyId));
        journeyDetailResponse.setFuddy(journeyQueryRepository.findFuddy(journeyId));
        journeyDetailResponse.setApplyList(journeyQueryRepository.findJourneyApproveApply(journeyId));
        journeyDetailResponse.setStatus(journeyApproveRepository.findByJourney_IdAndParticipant_Id(journeyId, memberId).orElse(JourneyApprove.builder().status(ParticipationStatus.NOT_APPLY).build()).getStatus());
        return journeyDetailResponse;
    }

    @Override
    public List<JourneyResponse> findAllByLeaderId(Long leaderId) {
        List<JourneyResponse> journeyResponses = journeyQueryRepository.findAllByLeaderId(leaderId);
        journeyResponses.forEach(journeyResponse -> {
            journeyResponse.setTravelerCnt(journeyQueryRepository.findTravelerCnt(journeyResponse.getId()));
            journeyResponse.setImage(journeyQueryRepository.findImage(journeyResponse.getId()));
        });
        return journeyResponses;
    }

    @Override
    public List<JourneyApplyResponse> findAllByMyApply(Long memberId) {
        List<JourneyApplyResponse> journeyResponses = journeyQueryRepository.findAllByMyApply(memberId);
        journeyResponses.forEach(journeyResponse -> {
            journeyResponse.setTravelerCnt(journeyQueryRepository.findTravelerCnt(journeyResponse.getId()));
            journeyResponse.setImage(journeyQueryRepository.findImage(journeyResponse.getId()));
        });
        return journeyResponses;
    }

    // TODO: 2023/06/22 KCH : query 튜닝
    @Override
    public JourneyLeaderDetailResponse findLeaderJourneyById(Long journeyId, Long leaderId) {
        JourneyLeaderDetailResponse journeyDetailResponse = journeyQueryRepository.findLeaderJourneyById(journeyId, leaderId);
        journeyDetailResponse.setTravelerCnt(journeyQueryRepository.findTravelerCnt(journeyId));
        journeyDetailResponse.setMyJourney(journeyQueryRepository.isMine(journeyId, leaderId));
        journeyDetailResponse.setJourneyPlaceResponseList(journeyQueryRepository.findJourneyPlace(journeyId));
        journeyDetailResponse.setLeader(journeyQueryRepository.findLeaderInfo(journeyId));
        journeyDetailResponse.setMemberApplyResponseList(journeyQueryRepository.findApplyMember(journeyId));
        return journeyDetailResponse;
    }
}

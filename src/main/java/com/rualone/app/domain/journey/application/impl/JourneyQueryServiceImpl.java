package com.rualone.app.domain.journey.application.impl;

import com.rualone.app.domain.attraction.validator.AttractionInfoValidator;
import com.rualone.app.domain.journey.application.JourneyQueryService;
import com.rualone.app.domain.journey.dao.JourneyQueryRepository;
import com.rualone.app.domain.journey.dto.request.AttractionInfoPathRequest;
import com.rualone.app.domain.journey.dto.response.AttractionInfoPathResponse;
import com.rualone.app.domain.journey.dto.response.JourneyResponse;
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
}

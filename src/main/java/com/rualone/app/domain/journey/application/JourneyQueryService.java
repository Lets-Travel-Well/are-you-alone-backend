package com.rualone.app.domain.journey.application;

import com.rualone.app.domain.journey.dto.request.AttractionInfoPathRequest;
import com.rualone.app.domain.journey.dto.response.AttractionInfoPathResponse;
import com.rualone.app.domain.journey.dto.response.JourneyApplyResponse;
import com.rualone.app.domain.journey.dto.response.JourneyDetailResponse;
import com.rualone.app.domain.journey.dto.response.JourneyResponse;

import java.util.List;

public interface JourneyQueryService {
    List<AttractionInfoPathResponse> findShortestPath(List<AttractionInfoPathRequest> attractionInfoPathRequests);
    List<JourneyResponse> findAll();
    JourneyDetailResponse findJourneyById(Long journeyId, Long memberId);

    List<JourneyResponse> findAllByLeaderId(Long memberId);

    List<JourneyApplyResponse> findAllByMyApply(Long memberId);
}

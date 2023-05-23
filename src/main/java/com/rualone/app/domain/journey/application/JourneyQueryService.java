package com.rualone.app.domain.journey.application;

import com.rualone.app.domain.journey.dto.request.AttractionInfoPathRequest;
import com.rualone.app.domain.journey.dto.response.AttractionInfoPathResponse;

import java.util.List;

public interface JourneyQueryService {
    List<AttractionInfoPathResponse> findShortestPath(List<AttractionInfoPathRequest> attractionInfoPathRequests);

}
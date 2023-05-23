package com.rualone.app.domain.hotplace.application;

import com.rualone.app.domain.hotplace.dto.response.HotPlaceResponse;

import java.util.List;

public interface HotPlaceQueryService {
    List<HotPlaceResponse> findTopAttractionInfo();
}
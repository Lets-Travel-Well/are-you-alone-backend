package com.rualone.app.domain.hotplace.application;

import com.rualone.app.domain.hotplace.dto.response.HotPlaceResponse;
import com.rualone.app.domain.hotplace.dto.response.MyPlaceResponse;

import java.util.List;

public interface HotPlaceQueryService {
//    List<HotPlaceResponse> findTopAttractionInfo(Long memberId);
    List<HotPlaceResponse> findTopAttractionInfo();

    List<MyPlaceResponse> findMyPlaceList(Long memberId);
}

package com.rualone.app.domain.attraction.application;

import com.rualone.app.domain.attraction.dto.response.AttractionInfoResponse;
import com.rualone.app.domain.attraction.entity.AttractionInfo;
import com.rualone.app.domain.attraction.entity.Gugun;
import com.rualone.app.domain.attraction.entity.Sido;

import java.util.List;

public interface AttractionQueryService {
    AttractionInfo findByContentId(int contentId);
    List<AttractionInfoResponse> findAllByCriteria(Integer sidoCode, Integer gugunCode, Integer contentTypeId, Long memberId);
    List<Sido> findSido();
    List<Gugun> findGugunBySido(int sidoCode);
}
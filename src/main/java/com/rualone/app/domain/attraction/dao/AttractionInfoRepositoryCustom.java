package com.rualone.app.domain.attraction.dao;

import com.rualone.app.domain.attraction.dto.response.AttractionInfoResponse;
import com.rualone.app.domain.attraction.entity.AttractionInfo;

import java.util.List;

public interface AttractionInfoRepositoryCustom {
    List<AttractionInfo> findAllByCriteria(Integer sidoCode, Integer gugunCode, Integer contentTypeId);
}

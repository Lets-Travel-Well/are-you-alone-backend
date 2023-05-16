package com.rualone.app.domain.attraction.application;

import com.rualone.app.domain.attraction.entity.AttractionInfo;
import com.rualone.app.domain.attraction.entity.Gugun;
import com.rualone.app.domain.attraction.entity.Sido;

import java.util.List;

public interface AttractionService {
    AttractionInfo findByContentId(int contentId);
    List<AttractionInfo> findAllByCriteria(Integer sidoCode, Integer gugunCode, Integer contentTypeId);
    List<Sido> findSido();
    List<Gugun> findGugunBySido(int sidoCode);
}
package com.rualone.app.domain.attraction.application;

import com.rualone.app.domain.attraction.dao.AttractionInfoRepository;
import com.rualone.app.domain.attraction.dao.GugunRepository;
import com.rualone.app.domain.attraction.dao.SidoRepository;
import com.rualone.app.domain.attraction.dto.response.AttractionInfoResponse;
import com.rualone.app.domain.attraction.entity.AttractionInfo;
import com.rualone.app.domain.attraction.entity.Gugun;
import com.rualone.app.domain.attraction.entity.Sido;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class AttractionServiceImpl implements AttractionService{

    private final AttractionInfoRepository attractionInfoRepository;
    private final GugunRepository gugunRepository;
    private final SidoRepository sidoRepository;
    @Override
    public AttractionInfo findByContentId(int contentId) {
        return null;
    }

    @Override
    public List<AttractionInfo> findAllByCriteria(Integer sidoCode, Integer gugunCode, Integer contentTypeId) {
        return attractionInfoRepository.findAllByCriteria(sidoCode, gugunCode, contentTypeId);
    }

    @Override
    public List<Sido> findSido() {
        return sidoRepository.findAll();
    }

    @Override
    public List<Gugun> findGugunBySido(int sidoCode) {
        Sido findSido = sidoRepository.findBySidoCode(sidoCode);
        return gugunRepository.findAllBySido(findSido);
    }
}

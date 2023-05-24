package com.rualone.app.domain.attraction.application;

import com.rualone.app.domain.attraction.dao.AttractionInfoQueryRepository;
import com.rualone.app.domain.attraction.dao.GugunRepository;
import com.rualone.app.domain.attraction.dao.SidoRepository;
import com.rualone.app.domain.attraction.dto.response.AttractionInfoResponse;
import com.rualone.app.domain.attraction.entity.AttractionInfo;
import com.rualone.app.domain.attraction.entity.Gugun;
import com.rualone.app.domain.attraction.entity.Sido;
import com.rualone.app.domain.hotplace.dao.HotPlaceQueryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class AttractionQueryServiceImpl implements AttractionQueryService{
    private final AttractionInfoQueryRepository attractionInfoQueryRepository;
    private final GugunRepository gugunRepository;
    private final SidoRepository sidoRepository;
    @Override
    public AttractionInfo findByContentId(int contentId) {
        return null;
    }

    @Override
    public List<AttractionInfoResponse> findAllByCriteria(Integer sidoCode, Integer gugunCode, Integer contentTypeId, Long memberId) {
        List<AttractionInfoResponse> findAttractions = attractionInfoQueryRepository.findAllByCriteria(sidoCode, gugunCode, contentTypeId);
        // TODO: 2023-05-24 : 긴급 쿼리를 엄청나게 보냄 꼮 쿼리 튜닝이 필요함
        for(AttractionInfoResponse attractionInfoResponse : findAttractions){
            attractionInfoResponse.isMyHotPlace(attractionInfoQueryRepository.isMyPlace(attractionInfoResponse.getContentId(), memberId));
            attractionInfoResponse.setLikeCnt(attractionInfoQueryRepository.checkLikeCnt(attractionInfoResponse.getContentId()));
        }

        return findAttractions;
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

package com.rualone.app.domain.hotplace.application.impl;

import com.rualone.app.domain.hotplace.application.HotPlaceQueryService;
import com.rualone.app.domain.hotplace.dao.HotPlaceQueryRepository;
import com.rualone.app.domain.hotplace.dto.response.HotPlaceResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class HotPlaceQueryServiceImpl implements HotPlaceQueryService {
    private final HotPlaceQueryRepository hotPlaceQueryRepository;

    // TODO: 2023/05/23 : 쿼리 수정이 필요함 1번에 가져 올 수 있는 걸 여러번에 거처서 가져옴
    // TODO: 2023/05/23 : 코드 구성도 이상함 + 변수명도 고민필요함
    @Override
    public List<HotPlaceResponse> findTopAttractionInfo() {
        List<HotPlaceResponse> hotPlaceResponses = hotPlaceQueryRepository.findTopAttractionInfo();
        for(HotPlaceResponse hotPlaceResponse : hotPlaceResponses){
//            hotPlaceResponse.isMyHotPlace(checkHotPlace(hotPlaceResponse.getContentId(), memberId));
        }
        return hotPlaceResponses;
    }
//    private Boolean checkHotPlace(Integer contentId, Long memberId){
//        return hotPlaceQueryRepository.isMyHotPlace(contentId, memberId);
//    }
}

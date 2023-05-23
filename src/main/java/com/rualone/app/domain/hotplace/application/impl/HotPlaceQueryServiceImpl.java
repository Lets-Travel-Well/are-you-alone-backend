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
    @Override
    public List<HotPlaceResponse> findTopAttractionInfo() {
        return hotPlaceQueryRepository.findTopAttractionInfo();
    }
}

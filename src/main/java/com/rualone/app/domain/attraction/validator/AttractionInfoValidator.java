package com.rualone.app.domain.attraction.validator;

import com.rualone.app.domain.attraction.dao.AttractionInfoRepository;
import com.rualone.app.domain.attraction.entity.AttractionInfo;
import com.rualone.app.global.error.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class AttractionInfoValidator {
    private final AttractionInfoRepository attractionInfoRepository;
    public AttractionInfo findByContentId(Integer contentId){
        return attractionInfoRepository.findByContentId(contentId).orElseThrow(() -> new NotFoundException(AttractionInfo.class, contentId));
    }
}

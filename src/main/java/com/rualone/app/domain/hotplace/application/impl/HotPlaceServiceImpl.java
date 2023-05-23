package com.rualone.app.domain.hotplace.application.impl;

import com.rualone.app.domain.attraction.entity.AttractionInfo;
import com.rualone.app.domain.attraction.validator.AttractionInfoValidator;
import com.rualone.app.domain.board.entity.Post;
import com.rualone.app.domain.board.entity.PostLike;
import com.rualone.app.domain.hotplace.application.HotPlaceService;
import com.rualone.app.domain.hotplace.dao.HotPlaceRepository;
import com.rualone.app.domain.hotplace.entity.HotPlace;
import com.rualone.app.domain.member.entity.Member;
import com.rualone.app.domain.member.validator.MemberValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional
public class HotPlaceServiceImpl implements HotPlaceService {
    private final HotPlaceRepository hotPlaceRepository;
    private final AttractionInfoValidator attractionInfoValidator;
    private final MemberValidator memberValidator;
    @Override
    public Boolean changeHotPlace(Long memberId, Integer contentId) {
        if(isExisted(memberId, contentId)){
            HotPlace findHotPlace = hotPlaceRepository.findByMember_IdAndAttractionInfo_ContentId(memberId, contentId).get();
            hotPlaceRepository.delete(findHotPlace);
            return Boolean.FALSE;
        }
        Member findMember = memberValidator.findById(memberId);
        AttractionInfo findAttractionInfo = attractionInfoValidator.findByContentId(contentId);
        hotPlaceRepository.save(new HotPlace(findMember, findAttractionInfo));
        return Boolean.TRUE;
    }
    private Boolean isExisted(Long memberId, Integer contentId){
        return hotPlaceRepository.existsHotPlaceByMember_IdAndAttractionInfo_ContentId(memberId, contentId);
    }
}

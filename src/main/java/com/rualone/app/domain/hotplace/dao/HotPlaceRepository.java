package com.rualone.app.domain.hotplace.dao;

import com.rualone.app.domain.hotplace.entity.HotPlace;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HotPlaceRepository extends JpaRepository<HotPlace, Long> {
    Optional<HotPlace> findByMember_IdAndAttractionInfo_ContentId(Long memberId, Integer contendId);
    Boolean existsHotPlaceByMember_IdAndAttractionInfo_ContentId(Long memberId, Integer contendId);
}

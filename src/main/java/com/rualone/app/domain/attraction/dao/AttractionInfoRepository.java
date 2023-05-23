package com.rualone.app.domain.attraction.dao;

import com.rualone.app.domain.attraction.entity.AttractionInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AttractionInfoRepository extends JpaRepository<AttractionInfo, Integer>{
    Optional<AttractionInfo> findByContentId(Integer contentId);
}

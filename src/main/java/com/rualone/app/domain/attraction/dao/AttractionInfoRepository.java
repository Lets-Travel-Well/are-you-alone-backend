package com.rualone.app.domain.attraction.dao;

import com.rualone.app.domain.attraction.entity.AttractionInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttractionInfoRepository extends JpaRepository<AttractionInfo, Integer> {
}

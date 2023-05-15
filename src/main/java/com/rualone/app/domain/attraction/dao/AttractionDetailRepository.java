package com.rualone.app.domain.attraction.dao;

import com.rualone.app.domain.attraction.entity.AttractionDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttractionDetailRepository extends JpaRepository<AttractionDetail, Integer> {
}

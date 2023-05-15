package com.rualone.app.domain.attraction.dao;

import com.rualone.app.domain.attraction.entity.AttractionDescription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttractionDescriptionRepository extends JpaRepository<AttractionDescription, Integer> {
}

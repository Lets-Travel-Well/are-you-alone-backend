package com.rualone.app.domain.journey.dao;

import com.rualone.app.domain.journey.entity.JourneyPlace;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JourneyPlaceRepository extends JpaRepository<JourneyPlace, Long> {
    JourneyPlace save(JourneyPlace journeyPlace);
}

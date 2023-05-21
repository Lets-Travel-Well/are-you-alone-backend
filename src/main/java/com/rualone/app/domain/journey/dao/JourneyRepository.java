package com.rualone.app.domain.journey.dao;

import com.rualone.app.domain.journey.entity.Journey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JourneyRepository extends JpaRepository<Journey, Long> {
}

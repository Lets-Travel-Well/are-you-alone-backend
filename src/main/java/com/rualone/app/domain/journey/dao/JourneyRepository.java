package com.rualone.app.domain.journey.dao;

import com.rualone.app.domain.journey.entity.Journey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JourneyRepository extends JpaRepository<Journey, Long> {
    Journey save(Journey journey);
    Optional<Journey> findById(Long id);
}

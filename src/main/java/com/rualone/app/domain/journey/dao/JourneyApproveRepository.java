package com.rualone.app.domain.journey.dao;

import com.rualone.app.domain.journey.entity.Journey;
import com.rualone.app.domain.journey.entity.JourneyApprove;
import com.rualone.app.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface JourneyApproveRepository extends JpaRepository<JourneyApprove, Long> {
    List<JourneyApprove> findByJourney(Journey journey);
    Optional<JourneyApprove> findById(Long id);
    Optional<JourneyApprove> findByJourneyAndParticipant(Journey journey, Member member);
    Optional<JourneyApprove> findByJourney_IdAndParticipant_Id(Long journeyId, Long memberId);
}

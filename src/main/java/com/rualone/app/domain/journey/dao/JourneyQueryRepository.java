package com.rualone.app.domain.journey.dao;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.rualone.app.domain.journey.dto.response.JourneyDetailResponse;
import com.rualone.app.domain.journey.dto.response.JourneyResponse;
import com.rualone.app.domain.journey.entity.ParticipationStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.querydsl.core.types.ExpressionUtils.count;
import static com.rualone.app.domain.journey.entity.QJourney.journey;
import static com.rualone.app.domain.journey.entity.QJourneyApprove.journeyApprove;
import static com.rualone.app.domain.journey.entity.QJourneyPlace.journeyPlace;

@Repository
@RequiredArgsConstructor
@Slf4j
public class JourneyQueryRepository {
    private final JPAQueryFactory jpaQueryFactory;

    public List<JourneyResponse> findAll() {
        List<JourneyResponse> journeyResponses = jpaQueryFactory
                .select(Projections.constructor(JourneyResponse.class,
                        journey.id,
                        journey.leader.nickName.as("leaderName"),
                        journey.subject,
                        journey.content,
                        journey.deadLine,
                        journey.startDay,
                        journey.travelerCntAll
                        ))
                .from(journey)
                .fetch();
        log.info(journeyResponses.toString());
        return journeyResponses;
    }

    public Long findTravelerCnt(Long journeyId) {
        return jpaQueryFactory.select(count(journeyApprove.id))
                .from(journeyApprove)
                .where(
                        journeyApprove.journey.id.eq(journeyId),
                        journeyApprove.status.eq(ParticipationStatus.AGREE))
                .fetchOne();
    }
    public String findImage(Long journeyId){
        return jpaQueryFactory.select(journeyPlace.attractionInfo.firstImage)
                .from(journeyPlace)
                .where(journeyPlace.journey.id.eq(journeyId))
                .fetchFirst();
    }
    public JourneyDetailResponse findJourneyById(Long journeyId, Long memberId){
        JourneyDetailResponse journeyDetailResponse = jpaQueryFactory
                .select(Projections.constructor(JourneyDetailResponse.class,
                        journey.id,
                        journey.subject,
                        journey.content,
                        journey.deadLine,
                        journey.startDay
                        ))
                .from(journey)
                .where(journey.id.eq(journeyId))
                .fetchOne();
        return journeyDetailResponse;
    }
}

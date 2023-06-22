package com.rualone.app.domain.journey.dao;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.rualone.app.domain.journey.dto.response.*;
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
                        journey.travelerAllCnt
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
                        journey.travelerAllCnt,
                        journey.deadLine,
                        journey.startDay
                        ))
                .from(journey)
                .where(journey.id.eq(journeyId))
                .fetchOne();
        return journeyDetailResponse;
    }

    public Boolean isMine(Long journeyId, Long memberId){
        Integer fetchOne = jpaQueryFactory
                .selectOne()
                .from(journeyApprove)
                .where(
                        journeyApprove.participant.id.eq(memberId),
                        journeyApprove.journey.id.eq((journeyId)),
                        journeyApprove.status.eq(ParticipationStatus.AGREE)
                )
                .fetchOne();
        return fetchOne != null;
    }

    public List<JourneyPlaceResponse> findJourneyPlace(Long journeyId) {
        List<JourneyPlaceResponse> journeyPlaceResponseList = jpaQueryFactory
                .select(Projections.constructor(JourneyPlaceResponse.class,
                        journeyPlace.attractionInfo.title,
                        journeyPlace.attractionInfo.contentId,
                        journeyPlace.attractionInfo.firstImage,
                        journeyPlace.content
                        ))
                .from(journeyPlace)
                .where(journey.id.eq(journeyId))
                .orderBy(journeyPlace.sequence.asc())
                .fetch();
        return journeyPlaceResponseList;
    }

    public JourneyParticipantResponse findLeaderInfo(Long journeyId) {
        JourneyParticipantResponse journeyParticipantResponse = jpaQueryFactory
                .select(Projections.constructor(JourneyParticipantResponse.class,
                        journey.leader.nickName,
                        journey.leader.footage
                        ))
                .from(journey)
                .where(journey.id.eq(journeyId))
                .fetchOne();
        return journeyParticipantResponse;
    }

    public List<JourneyParticipantResponse> findFuddy(Long journeyId) {
        List<JourneyParticipantResponse> journeyParticipantResponses = jpaQueryFactory
                .select(Projections.constructor(JourneyParticipantResponse.class,
                        journeyApprove.participant.nickName,
                        journeyApprove.participant.footage
                ))
                .from(journeyApprove)
                .where(journeyApprove.journey.id.eq(journeyId))
                .fetch();
        return journeyParticipantResponses;
    }

    public List<JourneyResponse> findAllByLeaderId(Long leaderId) {
        List<JourneyResponse> journeyResponses = jpaQueryFactory
                .select(Projections.constructor(JourneyResponse.class,
                        journey.id,
                        journey.leader.nickName.as("leaderName"),
                        journey.subject,
                        journey.content,
                        journey.deadLine,
                        journey.startDay,
                        journey.travelerAllCnt
                ))
                .from(journey)
                .where(journey.leader.id.eq(leaderId))
                .fetch();
        log.info(journeyResponses.toString());
        return journeyResponses;
    }

    public List<JourneyApplyResponse> findAllByMyApply(Long memberId) {
        List<JourneyApplyResponse> journeyResponses = jpaQueryFactory
                .select(Projections.constructor(JourneyApplyResponse.class,
                        journey.id,
                        journey.leader.nickName.as("leaderName"),
                        journey.subject,
                        journey.content,
                        journey.deadLine,
                        journey.startDay,
                        journey.travelerAllCnt,
                        journeyApprove.status
                ))
                .from(journey)
                .join(journeyApprove)
                .on(journey.id.eq(journeyApprove.journey.id))
                .where(journeyApprove.participant.id.eq(memberId))
                .fetch();
        log.info(journeyResponses.toString());
        return journeyResponses;
    }
}

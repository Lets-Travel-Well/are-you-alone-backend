package com.rualone.app.domain.journey.application.impl;

import com.rualone.app.domain.journey.application.JourneyApproveService;
import com.rualone.app.domain.journey.dao.JourneyApproveRepository;
import com.rualone.app.domain.journey.dto.request.JourneyAgreeRequest;
import com.rualone.app.domain.journey.dto.request.JourneyDisAgreeRequest;
import com.rualone.app.domain.journey.dto.request.JourneyJoinRequest;
import com.rualone.app.domain.journey.entity.Journey;
import com.rualone.app.domain.journey.entity.JourneyApprove;
import com.rualone.app.domain.journey.entity.ParticipationStatus;
import com.rualone.app.domain.journey.error.NotLeaderException;
import com.rualone.app.domain.journey.error.OutOfNumberException;
import com.rualone.app.domain.journey.validator.JourneyValidator;
import com.rualone.app.domain.member.entity.Member;
import com.rualone.app.domain.member.validator.MemberValidator;
import com.rualone.app.global.error.AlreadyExistException;
import com.rualone.app.global.error.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional
public class JourneyApproveServiceImpl implements JourneyApproveService {
    private final JourneyValidator journeyValidator;
    private final JourneyApproveRepository journeyApproveRepository;
    private final MemberValidator memberValidator;
    @Override
    public void save(JourneyJoinRequest journeyJoinRequest, Long memberId) {
        Journey journey = journeyValidator.findById(journeyJoinRequest.getJourneyId());
        Member member = memberValidator.findById(memberId);
        // 인원 수 다 찾는가 확인하기
        List<JourneyApprove> journeyApproves = journeyApproveRepository.findByJourney(journey);
        if(journey.getTravelerAllCnt() <= journeyApproves.size()){
            throw new OutOfNumberException(JourneyApprove.class, journeyApproves.size(), journey.getTravelerAllCnt());
        }
        // 해당 건에 대해 요청 했는가 확인
        Optional<JourneyApprove> findJourneyApprove = journeyApproveRepository.findByJourneyAndParticipant(journey, member);
        if(findJourneyApprove.isPresent()){
            throw new AlreadyExistException(JourneyApprove.class, findJourneyApprove.get().getId());
        }
        // TODO: 2023-05-22 : 코드 통일성 어긋남 매퍼 적용에 대해 생각해보기
        journeyApproveRepository.save(
                JourneyApprove.builder()
                .participant(member)
                .journey(journey)
                .status(ParticipationStatus.APPLY)
                .build());
    }

    @Override
    public void changeStatusAgree(JourneyAgreeRequest journeyAgreeRequest, Long leaderId) {
        Member leader = memberValidator.findById(leaderId);
        Member fuddy = memberValidator.findById(journeyAgreeRequest.getMemberId());
        Journey journey = journeyValidator.findById(journeyAgreeRequest.getJourneyId());
        log.info(journey.getLeader().getId().toString());
        isLeaderOfJourney(journey, leader.getId());
        JourneyApprove findJourneyApprove = journeyApproveRepository.findByJourneyAndParticipant(journey, fuddy)
                .orElseThrow(() -> new NotFoundException(JourneyApproveService.class, 0L));
        findJourneyApprove.changeToAgree();
    }

    @Override
    public void changeStatusDisAgree(JourneyDisAgreeRequest journeyDisAgreeRequest, Long leaderId) {
        Member leader = memberValidator.findById(leaderId);
        Member fuddy = memberValidator.findById(journeyDisAgreeRequest.getMemberId());
        Journey journey = journeyValidator.findById(journeyDisAgreeRequest.getJourneyId());
        log.info(journey.getLeader().getId().toString());
        isLeaderOfJourney(journey, leader.getId());
        JourneyApprove findJourneyApprove = journeyApproveRepository.findByJourneyAndParticipant(journey, fuddy)
                .orElseThrow(() -> new NotFoundException(JourneyApproveService.class, 0L));
        findJourneyApprove.changeToDisAgree();
    }
    private void isLeaderOfJourney(Journey journey, Long loginUserId){
        if(journey.getLeader().getId() != loginUserId){
            throw new NotLeaderException(loginUserId, journey.getId());
        }
    }
}

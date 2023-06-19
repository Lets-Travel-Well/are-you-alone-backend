package com.rualone.app.domain.follow.application;

import com.rualone.app.domain.follow.dao.FollowQueryRepository;
import com.rualone.app.domain.follow.dao.FollowRepository;
import com.rualone.app.domain.follow.dto.request.FollowCreateRequest;
import com.rualone.app.domain.follow.dto.request.FollowDeleteRequest;
import com.rualone.app.domain.follow.entity.Follow;
import com.rualone.app.domain.member.entity.Member;
import com.rualone.app.domain.member.validator.MemberValidator;
import com.rualone.app.global.error.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class FollowServiceImpl implements FollowService{

    private final FollowRepository followRepository;
    private final FollowQueryRepository followQueryRepository;
    private final MemberValidator memberValidator;

    @Override
    public void delete(FollowDeleteRequest followDeleteRequest, Long followerId) {
//        log.info("followServiceImpl의 delete 접속 완료");
//        if(followQueryRepository.findByRow(followDeleteRequest)){
//            log.info("삭제할 데이터 검색됨");
//            log.info("followDeleteRequest 값 ");
//            log.info(followDeleteRequest.toString());
//
//
//            Follow follow = followDeleteRequest.toEntity(followDeleteRequest);
//
//
//            log.info("follow.toString 값");
//            log.info(follow.toString());
//            followRepository.delete(follow);
//            followRepository.flush();
////            followRepository.delete(followDeleteRequest.toEntity(followDeleteRequest));
        Member follower = memberValidator.findById(followerId);
        Member followee = memberValidator.findById(followDeleteRequest.getFolloweeId());
        Follow findFollow = followRepository.findByFollowerAndFollowee(follower, followee)
                .orElseThrow(() -> new NotFoundException(Follow.class, 0L));
        followRepository.delete(findFollow);
    }

    @Override
    public void create(FollowCreateRequest followCreateRequest, Long followerId) {
        log.info("followServiceImpl의 create 접속 완료");
        Member follower = memberValidator.findById(followerId);
        Member followee = memberValidator.findById(followCreateRequest.getFolloweeId());
        log.info(follower.toString());
        log.info(followee.toString());
        followRepository.save(new Follow().createFollow(follower, followee));
    }


    /*
    1. dto => entity
    2. follow 말고 현재 로그인 사용자로 정보가져올 수 있음
     */
}

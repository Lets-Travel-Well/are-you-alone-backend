package com.rualone.app.domain.follow.application;

import com.rualone.app.domain.follow.dao.FollowQueryRepository;
import com.rualone.app.domain.follow.dto.response.FolloweeResponse;
import com.rualone.app.domain.follow.dto.response.FollowerResponse;
import com.rualone.app.domain.follow.entity.Follow;
import com.rualone.app.domain.member.entity.Member;
import com.rualone.app.domain.member.validator.MemberValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class FollowQueryServiceImpl implements FollowQueryService{

    private final FollowQueryRepository followQueryRepository;
    private final MemberValidator memberValidator;
//    @Override
//    public List<Follow> read(Member followee) {
//        log.info("followServiceImpl의 read접속 완료");
//        log.info(String.valueOf(followee));
//        List<Follow> list = followQueryRepository.findByFollowee(followee);
//        log.info("followServiceImpl의 list 사이즈 출력");
//        log.info(String.valueOf(list.size()));
//        return list;
//    }

    @Override
    public List<FollowerResponse> findByFollowee(Long followeeId) {
        log.info("followQuery Service findByFollowee 접속");
        log.info(followeeId.toString());
//        Member followee = memberValidator.findById(followeeId);
        log.info("followee 정보 출력");
//        log.info(followee.toString());
        return followQueryRepository.findByFollowee(followeeId);
    }

    @Override
    public List<FolloweeResponse> findByFollower(Long followerId) {
        return followQueryRepository.findByFollower(followerId);
    }
}

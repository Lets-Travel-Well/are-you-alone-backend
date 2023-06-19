package com.rualone.app.domain.follow.dao;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.rualone.app.domain.follow.dto.response.FolloweeResponse;
import com.rualone.app.domain.follow.dto.response.FollowerResponse;
import com.rualone.app.domain.follow.entity.QFollow;
import com.rualone.app.domain.member.entity.QMember;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

// YHJ : READ 할 때 쓸 repository
@Repository
@RequiredArgsConstructor
@Slf4j
public class FollowQueryRepository {

    private final JPAQueryFactory jpaQueryFactory;
    public List<FollowerResponse> findByFollowee(Long followeeId) {
        QFollow follow = QFollow.follow;
        QMember member = QMember.member;

        return jpaQueryFactory
                .select(Projections.constructor(FollowerResponse.class, member.id, member.nickName))
                .from(follow).innerJoin(member)
                .on(follow.followee.id.eq(member.id))
                .where(follow.follower.id.eq(followeeId))  // 수정된 부분
                .fetch();
    }

    public List<FolloweeResponse> findByFollower(Long followerId) {
        QFollow follow = QFollow.follow;
        QMember member = QMember.member;

        return jpaQueryFactory
                .select(Projections.constructor(FolloweeResponse.class, member.id, member.nickName))
                .from(follow).innerJoin(member)
                .on(follow.follower.id.eq(member.id))
                .where(follow.followee.id.eq(followerId))  // 수정된 부분
                .fetch();
    }
}

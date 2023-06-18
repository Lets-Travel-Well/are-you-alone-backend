package com.rualone.app.domain.follow.dao;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.rualone.app.domain.follow.dto.response.FollowReadResponse;
import com.rualone.app.domain.follow.entity.Follow;
import com.rualone.app.domain.follow.entity.QFollow;
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
    public List<Follow> findByFollowee(Long followee) {
        QFollow follow = QFollow.follow;

        return jpaQueryFactory
                .select(follow)
                .from(follow)
                .where(follow.followee.eq(followee))
                .fetch();
    }
}

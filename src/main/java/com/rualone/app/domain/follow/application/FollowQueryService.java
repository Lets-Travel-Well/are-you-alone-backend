package com.rualone.app.domain.follow.application;

import com.rualone.app.domain.follow.dto.response.FolloweeResponse;
import com.rualone.app.domain.follow.dto.response.FollowerResponse;
import com.rualone.app.domain.follow.entity.Follow;
import com.rualone.app.domain.member.entity.Member;

import java.util.List;

public interface FollowQueryService {

    List<FollowerResponse> findByFollowee(Long followeeId);

    List<FolloweeResponse> findByFollower(Long followerId);
}

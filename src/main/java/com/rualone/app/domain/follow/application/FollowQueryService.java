package com.rualone.app.domain.follow.application;

import com.rualone.app.domain.follow.entity.Follow;

import java.util.List;

public interface FollowQueryService {

    List<Follow> read(Long followee);
}

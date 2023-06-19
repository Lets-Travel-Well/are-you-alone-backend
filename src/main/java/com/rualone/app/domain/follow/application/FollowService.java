package com.rualone.app.domain.follow.application;

import com.rualone.app.domain.follow.dto.request.FollowCreateRequest;
import com.rualone.app.domain.follow.dto.request.FollowDeleteRequest;
import com.rualone.app.domain.follow.entity.Follow;

import java.util.List;

public interface FollowService {

    void create(FollowCreateRequest followCreateRequest, Long follwerId);

    void delete(FollowDeleteRequest followDeleteRequest, Long followerId);
}

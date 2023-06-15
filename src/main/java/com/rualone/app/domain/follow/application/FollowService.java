package com.rualone.app.domain.follow.application;

import com.rualone.app.domain.follow.dto.request.FollowDeleteRequest;

public interface FollowService {
    void delete(FollowDeleteRequest followDeleteRequest);
}

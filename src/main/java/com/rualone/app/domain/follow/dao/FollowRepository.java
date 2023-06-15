package com.rualone.app.domain.follow.dao;

import com.rualone.app.domain.follow.dto.request.FollowDeleteRequest;
import com.rualone.app.domain.follow.entity.Follow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FollowRepository extends JpaRepository<Follow, Long> {

    void delete(FollowDeleteRequest followDeleteRequest);
}

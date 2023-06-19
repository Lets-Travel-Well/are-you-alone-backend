package com.rualone.app.domain.follow.dao;

import com.rualone.app.domain.follow.entity.Follow;
import com.rualone.app.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

// YHJ : CUD 할 때 쓸 repository
public interface FollowRepository extends JpaRepository<Follow, Long> {
    Follow save(Follow follow);
    Optional<Follow> findByFollowerAndFollowee(Member follower, Member followee);
    void delete(Follow follow);
}

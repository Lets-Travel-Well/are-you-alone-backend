package com.rualone.app.domain.follow.dao;

import com.rualone.app.domain.follow.entity.Follow;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// YHJ : CUD 할 때 쓸 repository
public interface FollowRepository extends JpaRepository<Follow, Long> {
    Follow save(Follow follow);
    void delete(Follow follow);

}

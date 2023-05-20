package com.rualone.app.domain.board.dao;

import com.rualone.app.domain.board.entity.PostLike;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostLikeRepository extends JpaRepository<PostLike, Long> {
    Optional<PostLike> findByMember_IdAndPost_Id(Long memberId, Long postId);
    Boolean existsPostLikeByMember_IdAndPost_Id(Long memberId, Long postId);
}

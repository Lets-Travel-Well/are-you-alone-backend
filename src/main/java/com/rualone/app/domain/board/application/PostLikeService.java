package com.rualone.app.domain.board.application;

public interface PostLikeService {
    Boolean changLike(Long memberId, Long postId);
}

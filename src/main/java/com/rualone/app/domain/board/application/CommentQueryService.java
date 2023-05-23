package com.rualone.app.domain.board.application;

import com.rualone.app.domain.board.dto.response.CommentResponse;
import com.rualone.app.domain.board.entity.Comment;

import java.util.List;

public interface CommentQueryService {
    List<CommentResponse> findAll(Long postId);
}

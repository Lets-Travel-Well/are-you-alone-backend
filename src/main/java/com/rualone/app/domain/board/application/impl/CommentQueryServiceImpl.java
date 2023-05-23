package com.rualone.app.domain.board.application.impl;

import com.rualone.app.domain.board.application.CommentQueryService;
import com.rualone.app.domain.board.dao.CommentQueryRepository;
import com.rualone.app.domain.board.dto.response.CommentResponse;
import com.rualone.app.domain.board.entity.Comment;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class CommentQueryServiceImpl implements CommentQueryService {
    private final CommentQueryRepository commentQueryRepository;
    @Override
    public List<CommentResponse> findAll(Long postId) {
        List<CommentResponse> commentResponses = commentQueryRepository.findAllByPostId(postId);
        return commentResponses;
    }
}

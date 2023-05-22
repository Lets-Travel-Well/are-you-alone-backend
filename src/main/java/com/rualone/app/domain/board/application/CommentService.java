package com.rualone.app.domain.board.application;

import com.rualone.app.domain.board.dto.request.CommentUpdateRequest;
import com.rualone.app.domain.board.entity.Comment;
import com.rualone.app.domain.board.dto.request.CommentCreateRequest;
import com.rualone.app.domain.memberOrigin.entity.Member;

import java.util.List;

public interface CommentService {
    Comment save(CommentCreateRequest commentCreateRequest, Member member);
    Comment findById(Long id);
    List<Comment> findAll();

    // TODO: 2023/05/20 :CQRS로 변경 필요 
    List<Comment> findAll(Long postId);
    Comment updateComment(CommentUpdateRequest commentUpdateRequest);
    void deleteComment(Long id);
}

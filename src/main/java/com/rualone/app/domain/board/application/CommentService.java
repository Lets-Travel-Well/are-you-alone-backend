package com.rualone.app.domain.board.application;

import com.rualone.app.domain.board.dto.request.CommentUpdateRequest;
import com.rualone.app.domain.board.entity.Comment;
import com.rualone.app.domain.board.dto.request.CommentCreateRequest;
import com.rualone.app.domain.member.entity.Member;

import java.util.List;

public interface CommentService {
    Comment save(CommentCreateRequest commentCreateRequest, Member member);
    Comment findById(Long id);
    List<Comment> findAll();
    Comment updateComment(CommentUpdateRequest commentUpdateRequest);
    void deleteComment(Long id);
}

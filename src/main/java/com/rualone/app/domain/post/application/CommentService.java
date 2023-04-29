package com.rualone.app.domain.post.application;

import com.rualone.app.domain.post.Comment;
import com.rualone.app.domain.post.dto.CommentUpdateDto;
import com.rualone.app.domain.post.dto.request.CommentCreateRequest;

import java.util.List;

public interface CommentService {
    Comment save(CommentCreateRequest commentCreateRequest);
    Comment findById(Long id);
    List<Comment> findAll();
    Comment updateComment(CommentUpdateDto commentupdateDto);
    void deleteComment(Long id);
}

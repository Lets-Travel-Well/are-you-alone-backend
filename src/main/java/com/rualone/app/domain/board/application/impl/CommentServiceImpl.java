package com.rualone.app.domain.board.application.impl;

import com.rualone.app.domain.board.application.CommentService;
import com.rualone.app.domain.board.entity.Comment;
import com.rualone.app.domain.board.dao.CommentRepository;
import com.rualone.app.domain.board.dto.CommentUpdateDto;
import com.rualone.app.domain.board.dto.request.CommentCreateRequest;
import com.rualone.app.global.error.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    @Override
    public Comment save(CommentCreateRequest commentCreateRequest) {
        return commentRepository.save(commentCreateRequest.toEntity());
    }

    @Override
    public Comment findById(Long id) {
        return commentRepository.findById(id).orElseThrow(()-> new NotFoundException(Comment.class, id));
    }

    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public Comment updateComment(CommentUpdateDto commentupdateDto) {
        Comment comment = findById(commentupdateDto.getId());
        comment.update(commentupdateDto);
        return comment;
    }

    @Override
    public void deleteComment(Long id) {
        Comment comment = findById(id);
        commentRepository.delete(comment);
    }
}

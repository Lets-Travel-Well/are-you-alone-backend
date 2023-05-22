package com.rualone.app.domain.board.application.impl;

import com.rualone.app.domain.board.application.CommentService;
import com.rualone.app.domain.board.dto.request.CommentUpdateRequest;
import com.rualone.app.domain.board.entity.Comment;
import com.rualone.app.domain.board.dao.CommentRepository;
import com.rualone.app.domain.board.dto.request.CommentCreateRequest;
import com.rualone.app.domain.board.entity.Post;
import com.rualone.app.domain.board.validator.CommentValidator;
import com.rualone.app.domain.board.validator.PostValidator;
import com.rualone.app.domain.member.entity.Member;
import com.rualone.app.global.error.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Slf4j
@RequiredArgsConstructor
@Service
@Transactional
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final PostValidator postValidator;
    private final CommentValidator commentValidator;
    @Override
    public Comment save(CommentCreateRequest commentCreateRequest, Member member) {
        Post findPost = postValidator.findById(commentCreateRequest.getPostId());
        return commentRepository.save(commentCreateRequest.toEntity(findPost, member));
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
    public List<Comment> findAll(Long postId) {
        Post findPost = postValidator.findById(postId);
        return commentRepository.findAllByPost(findPost);
    }

    @Override
    public Comment updateComment(CommentUpdateRequest commentUpdateRequest) {
        Comment comment = commentValidator.findById(commentUpdateRequest.getId());
        comment.update(commentUpdateRequest);
        return comment;
    }

    @Override
    public void deleteComment(Long id) {
        Comment comment = commentValidator.findById(id);
        commentRepository.delete(comment);
    }
}

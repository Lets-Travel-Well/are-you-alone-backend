package com.rualone.app.domain.board.validator;

import com.rualone.app.domain.board.dao.CommentRepository;
import com.rualone.app.domain.board.entity.Comment;
import com.rualone.app.global.error.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class CommentValidator {
    private final CommentRepository commentRepository;
    public Comment findById(Long id){
        return commentRepository.findById(id).orElseThrow(() -> new NotFoundException(Comment.class, id));
    }
}

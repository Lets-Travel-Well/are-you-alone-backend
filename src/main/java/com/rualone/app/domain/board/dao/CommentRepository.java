package com.rualone.app.domain.board.dao;

import com.rualone.app.domain.board.entity.Comment;
import com.rualone.app.domain.board.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    Comment save(Comment comment);
    Optional<Comment> findById(Long id);
    List<Comment> findAll();
    List<Comment> findAllByPost(Post post);
    void delete(Comment comment);
}

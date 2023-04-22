package com.rualone.app.domain.post.dao;

import com.rualone.app.domain.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
    Post save(Post post);
    Optional<Post> findById(Long id);
    List<Post> findAll();
    void delete(Post post);
}

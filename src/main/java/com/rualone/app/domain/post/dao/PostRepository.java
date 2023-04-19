package com.rualone.app.domain.post.dao;

import com.rualone.app.domain.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}

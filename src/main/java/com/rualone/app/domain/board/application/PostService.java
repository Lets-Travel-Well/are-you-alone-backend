package com.rualone.app.domain.board.application;

import com.rualone.app.domain.board.Post;
import com.rualone.app.domain.board.dto.request.PostCreateRequest;
import com.rualone.app.domain.board.dto.request.PostUpdateRequest;

import java.util.List;

public interface PostService {
    Post save(PostCreateRequest postCreateRequest);
    Post findById(Long id);
    List<Post> findAll();
    Post updatePost(PostUpdateRequest postUpdateRequest);
    void deletePost(Long id);
}

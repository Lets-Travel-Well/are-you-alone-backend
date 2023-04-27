package com.rualone.app.domain.post.application;

import com.rualone.app.domain.post.Post;
import com.rualone.app.domain.post.dto.request.PostCreateRequest;
import com.rualone.app.domain.post.dto.PostUpdateDto;

import java.util.List;

public interface PostService {
    Post save(PostCreateRequest postCreateRequest);
    Post findById(Long id);
    List<Post> findAll();
    Post updatePost(PostUpdateDto postUpdateDto);
    void deletePost(Long id);
}

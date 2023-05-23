package com.rualone.app.domain.board.application;

import com.rualone.app.domain.board.entity.Post;
import com.rualone.app.domain.board.dto.request.PostCreateRequest;
import com.rualone.app.domain.board.dto.request.PostUpdateRequest;
import com.rualone.app.domain.member.entity.Member;


public interface PostService {
    Post save(PostCreateRequest postCreateRequest, Member member);
    Post updatePost(PostUpdateRequest postUpdateRequest);
    void deletePost(Long id);
    Post findById(Long id);
}

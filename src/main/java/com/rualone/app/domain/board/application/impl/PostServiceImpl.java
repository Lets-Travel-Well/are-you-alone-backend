package com.rualone.app.domain.board.application.impl;

import com.rualone.app.domain.board.application.PostService;
import com.rualone.app.domain.board.entity.Post;
import com.rualone.app.domain.board.dao.PostRepository;
import com.rualone.app.domain.board.dto.request.PostCreateRequest;
import com.rualone.app.domain.board.dto.request.PostUpdateRequest;
import com.rualone.app.domain.member.entity.Member;
import com.rualone.app.global.error.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    @Override
    public Post save(PostCreateRequest postCreateRequest, Member member) {
        return postRepository.save(postCreateRequest.toEntity(member));
    }

    @Override
    public Post updatePost(PostUpdateRequest postUpdateRequest) {
        Post post = findById(postUpdateRequest.getId());
        post.update(postUpdateRequest);
        return post;
    }

    @Override
    public void deletePost(Long id) {
        Post post = findById(id);
        postRepository.delete(post);
    }
    private Post findById(Long id) {
        return postRepository.findById(id).orElseThrow(() -> new NotFoundException(Post.class, id));
    }
}

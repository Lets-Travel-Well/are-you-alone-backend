package com.rualone.app.domain.board.application.impl;

import com.rualone.app.domain.board.application.PostService;
import com.rualone.app.domain.board.entity.Post;
import com.rualone.app.domain.board.dao.PostRepository;
import com.rualone.app.domain.board.dto.request.PostCreateRequest;
import com.rualone.app.domain.board.dto.request.PostUpdateRequest;
import com.rualone.app.domain.board.validator.PostValidator;
import com.rualone.app.domain.member.entity.Member;
import com.rualone.app.global.error.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Slf4j
@RequiredArgsConstructor
@Service
@Transactional
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final PostValidator postValidator;
    @Override
    public Post save(PostCreateRequest postCreateRequest, Member member) {
        return postRepository.save(postCreateRequest.toEntity(member));
    }

    @Override
    public Post updatePost(PostUpdateRequest postUpdateRequest) {
        Post post = postValidator.findById(postUpdateRequest.getId());
        post.update(postUpdateRequest);
        return post;
    }

    @Override
    public void deletePost(Long id) {
        Post post = postValidator.findById(id);
        postRepository.delete(post);
    }
    @Transactional(readOnly = true)
    public Post findById(Long id) {
        return postRepository.findById(id).orElseThrow(() -> new NotFoundException(Post.class, id));
    }
}

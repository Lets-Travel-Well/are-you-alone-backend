package com.rualone.app.domain.board.application;

import com.rualone.app.domain.board.entity.Post;
import com.rualone.app.domain.board.dao.PostRepository;
import com.rualone.app.domain.board.dto.request.PostCreateRequest;
import com.rualone.app.domain.board.dto.request.PostUpdateRequest;
import com.rualone.app.global.error.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;
    @Override
    public Post save(PostCreateRequest postCreateRequest) {
        return postRepository.save(postCreateRequest.toEntity());
    }

    @Override
    public Post findById(Long id) {
        return postRepository.findById(id).orElseThrow(() -> new NotFoundException(Post.class, id));
    }

    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
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
}

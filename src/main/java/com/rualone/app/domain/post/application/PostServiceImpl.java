package com.rualone.app.domain.post.application;

import com.rualone.app.domain.post.Post;
import com.rualone.app.domain.post.dao.PostRepository;
import com.rualone.app.domain.post.dto.request.PostCreateRequest;
import com.rualone.app.domain.post.dto.PostUpdateDto;
import com.rualone.app.global.error.AlreadyExistException;
import com.rualone.app.global.error.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
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
    public Post updatePost(PostUpdateDto postUpdateDto) {
        Post post = findById(postUpdateDto.getId());
        post.update(postUpdateDto);
        return post;
    }

    @Override
    public void deletePost(Long id) {
        Post post = findById(id);
        postRepository.delete(post);
    }
}

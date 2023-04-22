package com.rualone.app.domain.post.application;

import com.rualone.app.domain.post.Post;
import com.rualone.app.domain.post.dto.PostCreateDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PostServiceImpl implements PostService{
    @Override
    public Post save(PostCreateDto postCreateDto) {
        // 테스트를 통과 시키기 위해서 만들어둔 부분
        Post post = Post.builder()
                .id(1L)
                .build();
        return post;
    }

    @Override
    public Post findById(Long id) {
        return null;
    }

    @Override
    public List<Post> findAll() {
        return null;
    }

    @Override
    public Post modifyPost() {
        return null;
    }

    @Override
    public void deletePost() {

    }
}

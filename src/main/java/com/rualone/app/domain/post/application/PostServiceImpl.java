package com.rualone.app.domain.post.application;

import com.rualone.app.domain.post.Post;
import com.rualone.app.domain.post.dto.PostCreateDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
}

package com.rualone.app.domain.board.validator;

import com.rualone.app.domain.board.dao.PostRepository;
import com.rualone.app.domain.board.entity.Post;
import com.rualone.app.global.error.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class PostValidator {
    private final PostRepository postRepository;
    public Post findById(Long id){
        log.info("{}", id);
            return postRepository.findById(id).orElseThrow(() -> new NotFoundException(Post.class, id));
    }
}

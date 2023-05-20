package com.rualone.app.domain.board.validator;

import com.rualone.app.domain.board.dao.PostRepository;
import com.rualone.app.domain.board.entity.Post;
import com.rualone.app.global.error.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class PostValidator {
    private final PostRepository postRepository;
    public Post findById(Long id){
        return postRepository.findById(id).orElseThrow(() -> new NotFoundException(Post.class, id));
    }
}

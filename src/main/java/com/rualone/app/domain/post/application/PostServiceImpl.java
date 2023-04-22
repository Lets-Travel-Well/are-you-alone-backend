package com.rualone.app.domain.post.application;

import com.rualone.app.domain.post.Post;
import com.rualone.app.domain.post.dao.PostRepository;
import com.rualone.app.domain.post.dto.PostCreateDto;
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
    public Post save(PostCreateDto postCreateDto) {
        // 테스트를 통과 시키기 위해서 만들어둔 부분
        return postRepository.save(postCreateDto.toEntity());
    }

    @Override
    public Post findById(Long id) {
        Optional<Post> post = postRepository.findById(id);
        if(post.isPresent()){
            return post.get();
        }
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

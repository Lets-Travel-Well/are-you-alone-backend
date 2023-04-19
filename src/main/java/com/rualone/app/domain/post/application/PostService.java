package com.rualone.app.domain.post.application;

import com.rualone.app.domain.post.Post;
import com.rualone.app.domain.post.dto.PostCreateDto;

public interface PostService {
    Post save(PostCreateDto postCreateDto);

}

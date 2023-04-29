package com.rualone.app.domain.post.api;

import com.rualone.app.domain.post.Post;
import com.rualone.app.domain.post.application.CommentService;
import com.rualone.app.domain.post.application.PostService;
import com.rualone.app.domain.post.dto.request.PostCreateRequest;
import com.rualone.app.domain.post.dto.response.PostResponse;
import com.rualone.app.global.api.ApiResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import static com.rualone.app.global.api.ApiResult.OK;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/post-management")
@Slf4j
public class PostApi {
    private final PostService postService;

    private final CommentService commentService;

    @PostMapping("/post")
    public ApiResult<?> savePost(@RequestBody PostCreateRequest postCreateRequest){
        Post createPost = postService.save(postCreateRequest);
        return OK(createPost);
    }

    @GetMapping("/post/{id}")
    public ApiResult<PostResponse> findPostById(@PathVariable("id") Long id){
        return OK(new PostResponse(postService.findById(id)));
    }
}

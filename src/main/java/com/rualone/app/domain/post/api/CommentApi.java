package com.rualone.app.domain.post.api;

import com.rualone.app.domain.post.Comment;
import com.rualone.app.domain.post.application.CommentService;
import com.rualone.app.domain.post.dto.request.CommentCreateRequest;
import com.rualone.app.domain.post.dto.response.CommentResponse;
import com.rualone.app.global.api.ApiResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import static com.rualone.app.global.api.ApiResult.OK;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/comment-management")
@Slf4j
public class CommentApi {

    private final CommentService commentService;

    @PostMapping("/post")
    public ApiResult<?> saveComment(@RequestBody CommentCreateRequest commentCreateRequest){
        Comment createComment = commentService.save(commentCreateRequest);
        return OK(createComment);
    }

    @GetMapping("/post/{id}")
    public ApiResult<CommentResponse> findCommentById(@PathVariable("id")Long id){
        return OK(new CommentResponse(commentService.findById(id)));
    }

}

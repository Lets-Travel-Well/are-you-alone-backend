package com.rualone.app.domain.board.api;

import com.rualone.app.domain.board.dto.request.CommentUpdateRequest;
import com.rualone.app.domain.board.entity.Comment;
import com.rualone.app.domain.board.application.CommentService;
import com.rualone.app.domain.board.dto.request.CommentCreateRequest;
import com.rualone.app.global.api.ApiResult;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import static com.rualone.app.global.api.ApiResult.OK;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/comment-management/comment")
@Slf4j
public class CommentApi {

    private final CommentService commentService;

    @Operation(summary = "comment 생성", description = "comment를 생성하는 API입니다")
    @PostMapping("/create")
    public ApiResult<Void> saveComment(@RequestBody CommentCreateRequest commentCreateRequest){
        Comment createComment = commentService.save(commentCreateRequest);
        return OK(null);
    }

    @Operation(summary = "comment 수정", description = "comment를 수정하는 API입니다. id는 해당 댓글의 id가 들어갑니다.")
    @PostMapping("/{id}/update")
    public ApiResult<Void> update(@PathVariable("id") Long id, @RequestBody CommentUpdateRequest commentUpdateRequest){
        commentUpdateRequest.setId(id);
        commentService.updateComment(commentUpdateRequest);
        return OK(null);
    }

    @Operation(summary = "comment 삭제", description = "comment를 삭제하는 API입니다. id는 해당 댓글의 id가 들어갑니다.")
    @GetMapping("/{id}/delete")
    public ApiResult<Void> delete(@PathVariable("id") Long id){
        commentService.deleteComment(id);
        return OK(null);
    }
}

package com.rualone.app.domain.board.api;

import com.rualone.app.domain.board.application.CommentService;
import com.rualone.app.domain.board.application.PostService;
import com.rualone.app.domain.board.dto.request.PostCreateRequest;
import com.rualone.app.domain.board.dto.request.PostUpdateRequest;
import com.rualone.app.domain.board.dto.response.PostDetailResponse;
import com.rualone.app.domain.board.dto.response.PostResponse;
import com.rualone.app.domain.member.application.MemberService;
import com.rualone.app.domain.member.entity.Member;
import com.rualone.app.global.api.ApiResult;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static com.rualone.app.global.api.ApiResult.OK;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/board-management/post")
@Slf4j
public class PostApi {
    private final PostService postService;

    private final CommentService commentService;
    private final MemberService memberService;

    @Operation(summary = "post 생성", description = "post를 생성하는 API입니다")
    @PostMapping("/create")
    public ApiResult<Void> savePost(@RequestBody PostCreateRequest postCreateRequest){
        Long memberId = 1L;
        Member findMember = memberService.findById(memberId);
        postService.save(postCreateRequest, findMember);
        return OK(null);
    }

    @Operation(summary = "post 단건 조회", description = "post를 상세조회하는 API입니다. id는 해당 포스트의 id가 들어갑니다.")
    @GetMapping("/{id}")
    public ApiResult<PostDetailResponse> findPostById(@PathVariable("id") Long id){
        // TODO: 2023/05/15 KCH : comment완성되면 수정 해야합니다.
        return OK(new PostDetailResponse(postService.findById(id)));
    }

    @Operation(summary = "post 전체 조회", description = "post전체 조회 API입니다")
    @GetMapping()
    public ApiResult<List<PostResponse>> findAll(){
        log.info("findAll");
        List<PostResponse> list = postService.findAll().stream()
                .map(PostResponse::new)
                .collect(Collectors.toList());
        return OK(list);
    }

    @Operation(summary = "post 수정", description = "post를 수정하는 API입니다. id는 해당 포스트의 id가 들어갑니다.")
    @PostMapping("/{id}/update")
    public ApiResult<Void> update(@PathVariable("id") Long id, @RequestBody PostUpdateRequest postUpdateRequest){
        log.info("modify");
        Long memberId = 0L;
        postUpdateRequest.setId(id);
        postService.updatePost(postUpdateRequest);
        return OK(null);
    }

    @Operation(summary = "post 삭제", description = "post를 삭제하는 API입니다. id는 해당 카드의 id가 들어갑니다.")
    @GetMapping("/{id}/delete")
    public ApiResult<Void> delete(@PathVariable("id") Long id){
        log.info("delete");
        postService.deletePost(id);
        return OK(null);
    }
}

package com.rualone.app.domain.board.api;

import com.rualone.app.domain.board.application.CommentService;
import com.rualone.app.domain.board.application.PostLikeService;
import com.rualone.app.domain.board.application.PostQueryService;
import com.rualone.app.domain.board.application.PostService;
import com.rualone.app.domain.board.dto.request.PostCreateRequest;
import com.rualone.app.domain.board.dto.request.PostUpdateRequest;
import com.rualone.app.domain.board.dto.response.PostDetailResponse;
import com.rualone.app.domain.board.dto.response.PostResponse;
import com.rualone.app.domain.member.application.MemberService;
import com.rualone.app.domain.member.entity.Member;
import com.rualone.app.global.api.ApiResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
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
    private final PostQueryService postQueryService;

    private final MemberService memberService;
    private final PostLikeService postLikeService;

    @Operation(summary = "post 생성", description = "post를 생성하는 API입니다")
    @PostMapping("/create")
    public ApiResult<Void> savePost(@RequestBody PostCreateRequest postCreateRequest, @Parameter(hidden = true) @AuthenticationPrincipal User user){
        Long memberId = Long.parseLong(user.getUsername());
        Member findMember = memberService.findById(memberId);
        postService.save(postCreateRequest, findMember);
        return OK(null);
    }

    @Operation(summary = "post 단건 조회", description = "post를 상세조회하는 API입니다. id는 해당 포스트의 id가 들어갑니다.")
    @GetMapping("/{id}")
    public ApiResult<PostDetailResponse> findPostById(@PathVariable("id") Long id){
        // TODO: 2023/05/15 KCH : comment완성되면 수정 해야합니다.
        return OK(postQueryService. findById(id));
    }

    @Operation(summary = "post 전체 조회", description = "post전체 조회 API입니다, page = 페이지의 넘버, size = 한 페이지의 게시글 수, sort = 정렬 기준입니다.")
    @GetMapping()
    public ApiResult<Page<PostResponse>> findAll(@PageableDefault(sort="id", direction = Sort.Direction.DESC) Pageable pageable){
        log.info("findAll");
        log.info(pageable.toString());
//        List<PostResponse> list = postService.findAll().stream()
//                .map(PostResponse::new)
//                .collect(Collectors.toList());
        Page<PostResponse> list = postQueryService.findAll(pageable);
        return OK(list);
    }

    @Operation(summary = "post 수정", description = "post를 수정하는 API입니다. id는 해당 포스트의 id가 들어갑니다.")
    @PostMapping("/{id}/update")
    public ApiResult<Void> update(@PathVariable("id") Long id, @RequestBody PostUpdateRequest postUpdateRequest){
        log.info("modify");
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

    @Operation(summary = "post 좋아요", description = "post 좋아요 API입니다. True시 좋아요를 누른 상태 False시 취소한 상태입니다.")
    @GetMapping("/{id}/like")
    public ApiResult<Boolean> changLike(@PathVariable("id") Long postId){
        Long memberId = 1L;
        return OK(postLikeService.changLike(memberId, postId));
    }
}

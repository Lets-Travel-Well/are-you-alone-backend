package com.rualone.app.domain.follow.api;

import com.rualone.app.domain.follow.application.FollowQueryService;
import com.rualone.app.domain.follow.application.FollowService;
import com.rualone.app.domain.follow.dto.request.FollowCreateRequest;
import com.rualone.app.domain.follow.dto.request.FollowDeleteRequest;
import com.rualone.app.domain.follow.dto.response.FolloweeResponse;
import com.rualone.app.domain.follow.dto.response.FollowerResponse;
import com.rualone.app.domain.follow.entity.Follow;
import com.rualone.app.domain.follow.validator.FollowValidator;
import com.rualone.app.domain.member.api.MemberApi;
import com.rualone.app.domain.member.application.MemberService;
import com.rualone.app.domain.member.entity.Member;
import com.rualone.app.domain.member.validator.MemberValidator;
import com.rualone.app.global.api.ApiResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static com.rualone.app.global.api.ApiResult.OK;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/follow-management")
@Slf4j
public class FollowApi {
    private final FollowService followService;
    private final FollowQueryService followQueryService;
    private final MemberService memberService;
    private final FollowValidator followValidator;
    private final MemberValidator memberValidator;

    @Operation(summary = "팔로우 등록", description = "팔로우를 등록하는 API입니다.(팔로우 신청)")
    @PostMapping("/follow")
    public ApiResult<Void> create(FollowCreateRequest followCreateRequest, @Parameter(hidden = true) @AuthenticationPrincipal User user){
        log.info("팔로우 등록 접속");
//        Long follwerId = Long.parseLong(user.getUsername());
        Long followerId = Long.valueOf("1");
        followService.create(followCreateRequest, followerId);
        return OK(null);
    }


    @Operation(summary = "팔로우 삭제", description = "팔로우를 삭제하는 API입니다.(팔로우 취소)")
    @DeleteMapping("/follow")
    public ApiResult<Void> delete(FollowDeleteRequest followDeleteRequest, @Parameter(hidden = true) @AuthenticationPrincipal User user) {
//        Long followerId = Long.valueOf(user.getUsername());
        log.info("팔로우 삭제 접속");
        Long followerId = Long.valueOf("1");
        followService.delete(followDeleteRequest, followerId);
        return OK(null);
    }

    @Operation(summary = "팔로워 목록 조회", description = "현재의 팔로워 목록을 조회하는 API입니다. user는 followee입니다")
    @GetMapping("/follower")
    public ApiResult<List<FollowerResponse>> getFollowerList(@Parameter(hidden = true) @AuthenticationPrincipal User user){
        log.info("팔로워 목록 조회 접속");
        Long followeeId = Long.valueOf(user.getUsername());
//        Long followeeId = Long.valueOf("1");

        List<FollowerResponse> list = followQueryService.findByFollowee(followeeId);
        log.info(list.toString());
        return OK(null);
    }

    @Operation(summary = "팔로잉 목록 조회", description = "현재의 팔로잉 목록을 조회하는 API입니다. user는 follower입니다.")
    @GetMapping("/followee")
    public ApiResult<List<FolloweeResponse>> getFolloweeList(@Parameter(hidden = true) @AuthenticationPrincipal User user){
        log.info("팔로잉 목록 조회 접속");
//        Long followerId = Long.valueOf(user.getUsername());
        Long followerId = Long.valueOf("1");
        List<FolloweeResponse> list = followQueryService.findByFollower(followerId);
        log.info(list.toString());

        return OK(null);
    }

    @Operation(summary = "팔로우 여부 체크", description = "팔로우를 확인하는 api")
    @GetMapping("/followcheck")
    public ApiResult<Boolean> getFollowCheck(@Parameter(hidden = true) @AuthenticationPrincipal User user, @RequestParam Long followeeId){
//        Member follower = memberValidator.findById(Long.valueOf(user.getUsername()));
//        Member followee = memberValidator.findById(followeeId);
        Member follower = memberValidator.findById(Long.valueOf(4));
        Member followee = memberValidator.findById(Long.valueOf(5));
        Follow check = followValidator.findByFollowerAndFollowee(follower, followee);
        log.info(check.toString());
        return OK(null);
    }

}

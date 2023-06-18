package com.rualone.app.domain.follow.api;

import com.rualone.app.domain.follow.application.FollowService;
import com.rualone.app.domain.follow.dto.request.FollowCreateRequest;
import com.rualone.app.domain.follow.dto.request.FollowDeleteRequest;
import com.rualone.app.domain.follow.entity.Follow;
import com.rualone.app.global.api.ApiResult;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

    @Operation(summary = "팔로우 등록", description = "팔로우를 등록하는 API입니다.")
    @PostMapping("/follow")
    public ApiResult<Void> create(@RequestParam("follower") Long follower, @RequestParam("followee") Long followee){
        FollowCreateRequest followCreateRequest = new FollowCreateRequest(follower, followee);
        log.info("들어옴");
        followService.create(followCreateRequest);
        return OK(null);
    }


    @Operation(summary = "팔로우 삭제", description = "팔로우를 삭제하는 API입니다.(팔로우 취소)")
    @DeleteMapping("/follow")
    public ApiResult<Void> delete(@RequestParam("follower") Long follower, @RequestParam("followee") Long followee) {
        FollowDeleteRequest followDeleteRequest = new FollowDeleteRequest(follower, followee);
        log.info("팔로우 삭제 접속");
        followService.delete(followDeleteRequest);
        return OK(null);
    }

    @Operation(summary = "팔로우 목록 조회", description = "user의 팔로워 목록을 조회하는 API입니다. user는 followee입니다")
    @GetMapping("/follow")
    public ApiResult<List<Long>> read(@RequestParam("followee") Long followee){
        log.info("팔로우 목록 조회 접속");
        List<Follow> list = followService.read(followee);
        log.info("리스트 사이즈");
        log.info(String.valueOf(list.size()));
        log.info(list.get(0).toString());
        return OK(null);
    }
}

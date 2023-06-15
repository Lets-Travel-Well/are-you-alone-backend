package com.rualone.app.domain.follow.api;

import com.rualone.app.domain.follow.application.FollowService;
import com.rualone.app.domain.follow.dto.request.FollowDeleteRequest;
import com.rualone.app.domain.follow.entity.Follow;
import com.rualone.app.global.api.ApiResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import static com.rualone.app.global.api.ApiResult.OK;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/follow-management")
@Slf4j
public class FollowApi {
    private final FollowService followService;

    @DeleteMapping("/follow")
    public ApiResult<Void> delete(@RequestParam("follower") Long follower, @RequestParam("followee") Long followee) {
        FollowDeleteRequest followDeleteRequest = new FollowDeleteRequest(follower, followee);
        followService.delete(followDeleteRequest);
        return OK(null);
    }

}

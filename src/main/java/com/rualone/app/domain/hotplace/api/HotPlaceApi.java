package com.rualone.app.domain.hotplace.api;

import com.rualone.app.domain.hotplace.application.HotPlaceService;
import com.rualone.app.global.api.ApiResult;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.rualone.app.global.api.ApiResult.OK;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/hotplace-management/hotplace")
@Slf4j
public class HotPlaceApi {
    private final HotPlaceService hotPlaceService;

    @Operation(summary = "attractionInfo 좋아요", description = "attractionInfo 좋아요 API입니다. True시 좋아요를 누른 상태 False시 취소한 상태입니다.")
    @GetMapping("/{id}/like")
    public ApiResult<Boolean> changLike(@PathVariable("id") Integer contentId){
        Long memberId = 1L;
        return OK(hotPlaceService.changeHotPlace(memberId, contentId));
    }
}

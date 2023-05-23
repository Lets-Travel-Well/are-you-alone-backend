package com.rualone.app.domain.hotplace.api;

import com.rualone.app.domain.hotplace.application.HotPlaceQueryService;
import com.rualone.app.domain.hotplace.application.HotPlaceService;
import com.rualone.app.domain.hotplace.dto.response.HotPlaceResponse;
import com.rualone.app.global.api.ApiResult;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.rualone.app.global.api.ApiResult.OK;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/hotplace-management/hotplace")
@Slf4j
public class HotPlaceApi {
    private final HotPlaceService hotPlaceService;
    private final HotPlaceQueryService hotPlaceQueryService;
    @Operation(summary = "attractionInfo 좋아요", description = "attractionInfo 좋아요 API입니다. True시 좋아요를 누른 상태 False시 취소한 상태입니다.")
    @GetMapping("/{id}/like")
    public ApiResult<Boolean> changLike(@PathVariable("id") Integer contentId){
        Long memberId = 1L;
        return OK(hotPlaceService.changeHotPlace(memberId, contentId));
    }
    @Operation(summary = "hotplace 보기", description = "hotplace 상위 10개 보여주는 API입니다.")
    @GetMapping()
    public ApiResult<List<HotPlaceResponse>> showHotPlace(){
        return OK(hotPlaceQueryService.findTopAttractionInfo());
    }

}

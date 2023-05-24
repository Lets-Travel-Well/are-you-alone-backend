package com.rualone.app.domain.attraction.api;

import com.rualone.app.domain.attraction.application.AttractionQueryService;
import com.rualone.app.domain.attraction.dto.response.AttractionInfoResponse;
import com.rualone.app.domain.attraction.entity.Gugun;
import com.rualone.app.domain.attraction.entity.Sido;
import com.rualone.app.global.api.ApiResult;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static com.rualone.app.global.api.ApiResult.OK;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/attraction-management")
@Slf4j
public class AttractionInfoApi {
    private final AttractionQueryService attractionQueryService;

    // TODO : 자료에 대한 validation처리가 필요함
    @GetMapping("/attraction")
    public ApiResult<List<AttractionInfoResponse>> getAttraction(@RequestParam(value="sidoCode", required=false) Integer sidoCode,
                                                                 @RequestParam(value="gugunCode", required=false) Integer gugunCode,
                                                                 @RequestParam(value="contentTypeId", required=false) Integer contentTypeId,
                                                                 @Parameter(hidden = true) @AuthenticationPrincipal User user){
        log.info("attraction");
        Long memberId = Long.parseLong(user.getUsername());
        return OK(attractionQueryService.findAllByCriteria(sidoCode, gugunCode, contentTypeId, memberId));
    }
    @GetMapping("/sido")
    public ApiResult<List<Sido>> getSido() {
        return OK(attractionQueryService.findSido());
    }
    @GetMapping("/gugun/{sidoCode}")
    public ApiResult<List<Gugun>> getGugun(@PathVariable int sidoCode) {
        log.info("gugun");
        log.info(String.valueOf(sidoCode));
        return OK(attractionQueryService.findGugunBySido(sidoCode));
    }
}

package com.rualone.app.domain.journey.api;

import com.rualone.app.domain.journey.application.JourneyService;
import com.rualone.app.global.api.ApiResult;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.rualone.app.global.api.ApiResult.OK;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/journey-management")
public class JourneyApi {
    private JourneyService journeyService;

    @Operation(summary = "journey 생성", description = "journey를 생성하는 API입니다.")
    @PostMapping("/create")
    public ApiResult<Void> saveJourney(@RequestBody ){
        return OK(null);
    }
}

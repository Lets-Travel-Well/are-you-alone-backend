package com.rualone.app.domain.journey.api;

import com.rualone.app.domain.journey.application.JourneyService;
import com.rualone.app.global.api.ApiResult;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static com.rualone.app.global.api.ApiResult.OK;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/journey-management/journey")
public class JourneyApi {
    private JourneyService journeyService;

    @Operation(summary = "최단경로 생성", description = "최단경로 만드는 API입니다.")
    @PostMapping("/path")
    public ApiResult<> findSh(){

    }
    @PostMapping("/journey/path")
    public ApiResult<List<JourneyPlacePathDto>> findShortestPath(@RequestBody List<JourneyPlacePathCreateRequest> journeyPlacePathCreateRequest){
        List<JourneyPlacePathDto> journeyPlacePathDto = journeyPlacePathCreateRequest.stream()
                .map(temp -> new JourneyPlacePathDto(attractionService.findByContentId(temp.getContentId())))
                .collect(Collectors.toList());
        return OK(journeyService.findShortestPath(journeyPlacePathDto));
    }

    @Operation(summary = "journey 생성", description = "journey를 생성하는 API입니다.")
    @PostMapping("/create")
    public ApiResult<Void> saveJourney(){
        return OK(null);
    }
}

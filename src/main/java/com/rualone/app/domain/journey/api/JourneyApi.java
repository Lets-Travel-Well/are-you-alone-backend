package com.rualone.app.domain.journey.api;

import com.rualone.app.domain.journey.application.JourneyQueryService;
import com.rualone.app.domain.journey.application.JourneyService;
import com.rualone.app.domain.journey.dto.request.AttractionInfoPathRequest;
import com.rualone.app.domain.journey.dto.response.AttractionInfoPathResponse;
import com.rualone.app.global.api.ApiResult;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class JourneyApi {
    private final JourneyService journeyService;
    private final JourneyQueryService journeyQueryService;

    @Operation(summary = "최단경로 생성", description = "최단경로 만드는 API입니다.")
    @PostMapping("/path")
    public ApiResult<List<AttractionInfoPathResponse>> findShortestPath(@RequestBody List<AttractionInfoPathRequest> attractionInfoPathRequest){
        log.info("{}", attractionInfoPathRequest.toString());

        return OK(journeyQueryService.findShortestPath(attractionInfoPathRequest));
    }
//    @PostMapping("/journey/path")
//    public ApiResult<List<JourneyPlacePathDto>> findShortestPath(@RequestBody List<JourneyPlacePathCreateRequest> journeyPlacePathCreateRequest){
//        List<JourneyPlacePathDto> journeyPlacePathDto = journeyPlacePathCreateRequest.stream()
//                .map(temp -> new JourneyPlacePathDto(attractionService.findByContentId(temp.getContentId())))
//                .collect(Collectors.toList());
//        return OK(journeyService.findShortestPath(journeyPlacePathDto));
//    }

    @Operation(summary = "journey 생성", description = "journey를 생성하는 API입니다.")
    @PostMapping("/create")
    public ApiResult<Void> saveJourney(){
        return OK(null);
    }
}

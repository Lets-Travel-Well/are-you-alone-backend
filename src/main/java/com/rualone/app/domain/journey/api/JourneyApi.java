package com.rualone.app.domain.journey.api;

import com.rualone.app.domain.journey.application.JourneyApproveService;
import com.rualone.app.domain.journey.application.JourneyQueryService;
import com.rualone.app.domain.journey.application.JourneyService;
import com.rualone.app.domain.journey.dto.request.AttractionInfoPathRequest;
import com.rualone.app.domain.journey.dto.request.JourneyCreateRequest;
import com.rualone.app.domain.journey.dto.request.JourneyJoinRequest;
import com.rualone.app.domain.journey.dto.response.AttractionInfoPathResponse;
import com.rualone.app.domain.member.application.MemberService;
import com.rualone.app.domain.member.entity.Member;
import com.rualone.app.global.api.ApiResult;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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
    private final MemberService memberService;
    private final JourneyApproveService journeyApproveService;

    @Operation(summary = "최단경로 생성", description = "최단경로 만드는 API입니다.")
    @PostMapping("/path")
    public ApiResult<List<AttractionInfoPathResponse>> findShortestPath(@RequestBody List<AttractionInfoPathRequest> attractionInfoPathRequest){
        log.info("{}", attractionInfoPathRequest.toString());

        return OK(journeyQueryService.findShortestPath(attractionInfoPathRequest));
    }
    @Operation(summary = "journey 생성", description = "journey를 생성하는 API입니다.")
    @PostMapping("/create")
    public ApiResult<Void> saveJourney(@RequestBody JourneyCreateRequest journeyCreateRequest){
        Long memberId = 1L;
        Member findMember = memberService.findById(memberId);
        log.info("{}", journeyCreateRequest.toString());
        journeyService.save(journeyCreateRequest, findMember);
        return OK(null);
    }
    // TODO: 2023-05-22 : 동행부터 구하기
//    @Operation(summary = "journey 전체보기", description = "journey들을 보는 API입니다")
//    public ApiResult<Void> findAllJourney(){
//        journeyQueryService.findAll();
//        return OK(null);
//    }

    @Operation(summary = "동행 신청하는 API", description = "동행신청하는 API입니다.")
    @PostMapping("/apply")
    public ApiResult<Void> joinJourney(@RequestBody JourneyJoinRequest journeyJoinRequest){
        Long memberId = 1L;
        Member findMember = memberService.findById(memberId);
        log.info(journeyJoinRequest.toString());
        journeyApproveService.save(journeyJoinRequest, findMember);
        return OK(null);
    }
}

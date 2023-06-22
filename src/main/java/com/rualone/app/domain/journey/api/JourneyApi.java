package com.rualone.app.domain.journey.api;

import com.rualone.app.domain.journey.application.JourneyApproveService;
import com.rualone.app.domain.journey.application.JourneyQueryService;
import com.rualone.app.domain.journey.application.JourneyService;
import com.rualone.app.domain.journey.dto.request.*;
import com.rualone.app.domain.journey.dto.response.*;
import com.rualone.app.domain.member.application.MemberService;
import com.rualone.app.global.api.ApiResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ApiResult<Void> saveJourney(@RequestBody JourneyCreateRequest journeyCreateRequest, @Parameter(hidden = true) @AuthenticationPrincipal User user){
        Long memberId = Long.parseLong(user.getUsername());
        log.info("{}", journeyCreateRequest.toString());
        journeyService.save(journeyCreateRequest, memberId);
        return OK(null);
    }
    // TODO: 2023-05-22 : 동행부터 구하기
    @Operation(summary = "journey 전체보기", description = "journey들을 보는 API입니다")
    @GetMapping()
    public ApiResult<List<JourneyResponse>> findAllJourney(){
        return OK(journeyQueryService.findAll());
    }
    @Operation(summary = "journey 단건 조회", description = "journey을 단건 조회하는 API입니다")
    @GetMapping("/{id}")
    public ApiResult<JourneyDetailResponse> findJourneyById(@PathVariable("id") Long journeyId, @Parameter(hidden = true) @AuthenticationPrincipal User user){
        log.info(user.getUsername());
        Long memberId = Long.parseLong(user.getUsername());
        return OK(journeyQueryService.findJourneyById(journeyId, memberId));
    }

    // TODO: 2023/06/22 KCH : api명 적절한가 고민하기
    // 내가 리더인 여행 목록 보기
    @Operation(summary = "내가 leader인 journey 전체 조회", description = "내가 leader인 journey들을 보는 API입니다")
    @GetMapping("/leader")
    public ApiResult<List<JourneyResponse>> findAllByLeaderId(@Parameter(hidden = true) @AuthenticationPrincipal User user){
        Long memberId = Long.parseLong(user.getUsername());
        return OK(journeyQueryService.findAllByLeaderId(memberId));
    }

    // 내가 리더인 여행 상세 조회
    @Operation(summary = "내가 리더인 journey 단건 조회", description = "내가 리더인 journey을 단건 조회하는 API입니다, id에는 여행 계획의 id가 들어갑니다")
    @GetMapping("/leader/{id}")
    public ApiResult<JourneyLeaderDetailResponse> findLeaderJourneyById(@PathVariable("id") Long journeyId, @Parameter(hidden = true) @AuthenticationPrincipal User user){
        Long leaderId = Long.parseLong(user.getUsername());
        return OK(journeyQueryService.findLeaderJourneyById(journeyId, leaderId));
    }

    // 내가 신청한 여행 목록 보기
    @Operation(summary = "내가 신청한 journey 전체 조회", description = "내가 신청한 journey들을 보는 API입니다")
    @GetMapping("/apply")
    public ApiResult<List<JourneyApplyResponse>> findAllByMyApply(@Parameter(hidden = true) @AuthenticationPrincipal User user){
        // TODO: 2023/06/22 : 로그인 사용자로 바꿔야함
        Long memberId = Long.parseLong(user.getUsername());
        return OK(journeyQueryService.findAllByMyApply(memberId));
    }

    @Operation(summary = "동행 신청하는 API", description = "동행신청하는 API입니다.")
    @PostMapping("/apply")
    public ApiResult<Void> joinJourney(@RequestBody JourneyJoinRequest journeyJoinRequest, @Parameter(hidden = true) @AuthenticationPrincipal User user){
        log.info(user.getUsername());
        Long memberId = Long.parseLong(user.getUsername());
        journeyApproveService.save(journeyJoinRequest, memberId);
        return OK(null);
    }

    // 동행 승인, 거부에 대하여 리턴 값을 생각해야함, frontend 팀장님과 논의 필요
    @Operation(summary = "동행을 승인하는 API", description = "동행을 승인하는 API입니다")
    @PostMapping("/agree")
    public ApiResult<Void> agreeJourney(@RequestBody JourneyAgreeRequest journeyAgreeRequest, @Parameter(hidden = true) @AuthenticationPrincipal User user){
        // TODO: 2023/06/22 : 로그인 사용자로 바꿔야함
        Long leaderId = Long.parseLong(user.getUsername());
        journeyApproveService.changeStatusAgree(journeyAgreeRequest, leaderId);
        return OK(null);
    }
    @Operation(summary = "동행을 거절하는 API", description = "동행을 거절하는 API입니다")
    @PostMapping("/disagree")
    public ApiResult<Void> disAgreeJourney(@RequestBody JourneyDisAgreeRequest journeyDisAgreeRequest, @Parameter(hidden = true) @AuthenticationPrincipal User user){
        Long leaderId = Long.parseLong(user.getUsername());
        journeyApproveService.changeStatusDisAgree(journeyDisAgreeRequest, leaderId);
        return OK(null);
    }
}

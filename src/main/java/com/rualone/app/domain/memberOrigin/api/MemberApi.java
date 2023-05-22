package com.rualone.app.domain.memberOrigin.api;

import com.rualone.app.domain.memberOrigin.application.MemberService;
import com.rualone.app.domain.memberOrigin.dto.request.MemberCreateRequest;
import com.rualone.app.domain.memberOrigin.dto.request.MemberLoginRequest;
import com.rualone.app.domain.memberOrigin.dto.request.MemberModifyRequest;
import com.rualone.app.domain.memberOrigin.dto.response.MemberResponse;
import com.rualone.app.global.api.ApiResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static com.rualone.app.global.api.ApiResult.OK;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user-management")
@Slf4j
public class MemberApi {
    private final MemberService memberService;

    @GetMapping("/check/{loginId}")
    public ApiResult<Boolean> checkLoginId(@PathVariable("loginId") String loginId){
        Boolean result = memberService.checkLoginId(loginId);
        return OK(result);
    }
    @PostMapping("/join")
    public ApiResult<Void> join(@RequestBody MemberCreateRequest memberCreateRequest){
        log.info(memberCreateRequest.toString());
        memberService.join(memberCreateRequest);
        return OK(null);
    }
    @GetMapping("/user/{loginId}")
    public ApiResult<MemberResponse> findMemberByLoginId(@PathVariable("loginId") String loginId){
        MemberResponse loginMember = new MemberResponse(memberService.findByLoginId(loginId));
        return OK(loginMember);
    }
    @PutMapping("/modify")
    public ApiResult<Void> modify(@RequestBody MemberModifyRequest memberModifyRequest){
        log.info(memberModifyRequest.toString());
        memberService.modify(memberModifyRequest);
        return OK(null);
    }
    @DeleteMapping("/user/{loginId}")
    public ApiResult<Void> delete(@PathVariable("loginId")String loginId){
        memberService.delete(loginId);
        return OK(null);
    }

    @PostMapping("/login")
    public ApiResult<Void> login(MemberLoginRequest memberLoginRequest, HttpSession session){
        MemberResponse loginInfo = new MemberResponse(memberService.login(memberLoginRequest));
        session.setAttribute("userInfo",loginInfo);
        return OK(null);
    }

    @GetMapping("/logout")
    public ApiResult<Void> logout(HttpServletRequest httpServletRequest){
        HttpSession session = httpServletRequest.getSession();
        session.invalidate();
        return OK(null);
    }
}

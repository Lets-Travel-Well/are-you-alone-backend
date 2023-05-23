package com.rualone.app.domain.member.api;

import com.rualone.app.domain.member.application.MemberService;
import com.rualone.app.domain.member.dto.request.MemberModifyRequest;
import com.rualone.app.domain.member.dto.response.MemberResponse;
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

    @GetMapping("/user/{email}")
    public ApiResult<MemberResponse> findMemberByEmail(@PathVariable("email") String email){
        MemberResponse loginMember = new MemberResponse(memberService.findByEmail(email));
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

    @GetMapping("/logout")
    public ApiResult<Void> logout(HttpServletRequest httpServletRequest){
        HttpSession session = httpServletRequest.getSession();
        session.invalidate();
        return OK(null);
    }
}

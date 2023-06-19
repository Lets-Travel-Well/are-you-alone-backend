package com.rualone.app.domain.member.api;

import com.rualone.app.domain.member.application.MemberService;
import com.rualone.app.domain.member.dto.request.MemberModifyRequest;
import com.rualone.app.domain.member.dto.response.MemberResponse;
import com.rualone.app.global.api.ApiResult;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    @PostMapping("/images/update/profileImg")
    public ApiResult<Void> updateProfileImg(@RequestPart MultipartFile profileImg, @Parameter(hidden = true) @AuthenticationPrincipal User user) {
//    public ApiResult<Void> updateProfileImg(MultipartFile profileImg, String userId) {
        memberService.updateProfileImg(profileImg, Long.parseLong(user.getUsername()));
//        memberService.updateProfileImg(profileImg, Long.parseLong(userId));
        return OK(null);
    }

    @PostMapping("/images/delete/profileImg")
    public ApiResult<Void> removeProfileImg(@Parameter(hidden = true) @AuthenticationPrincipal User user) {
//    public ApiResult<Void> removeProfileImg(String userId) {
        log.info("Controller entered");
        memberService.removeProfileImg(Long.parseLong(user.getUsername()));
//        memberService.removeProfileImg(Long.parseLong(userId));
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

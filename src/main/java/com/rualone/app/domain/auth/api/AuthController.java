package com.rualone.app.domain.auth.api;

import com.rualone.app.domain.auth.params.KakaoLoginParams;
import com.rualone.app.domain.auth.params.NaverLoginParams;
import com.rualone.app.domain.auth.application.OAuthLoginService;
import com.rualone.app.domain.auth.tokens.AuthTokens;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
@Slf4j
public class AuthController {
    private final OAuthLoginService oAuthLoginService;

    //Todo : ResponseEntity 수정
    @PostMapping("/kakao")
    public ResponseEntity<AuthTokens> loginKakao(@RequestBody KakaoLoginParams params) {
        log.info(params.toString());
        return ResponseEntity.ok(oAuthLoginService.login(params));
    }

    @PostMapping("/naver")
    public ResponseEntity<AuthTokens> loginNaver(@RequestBody NaverLoginParams params) {
        return ResponseEntity.ok(oAuthLoginService.login(params));
    }
}

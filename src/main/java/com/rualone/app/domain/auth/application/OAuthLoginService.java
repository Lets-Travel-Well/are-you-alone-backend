package com.rualone.app.domain.auth.application;

import com.rualone.app.domain.auth.dto.infoResponse.OAuthInfoResponse;
import com.rualone.app.domain.auth.params.OAuthLoginParams;
import com.rualone.app.domain.auth.tokens.AuthTokensGenerator;
import com.rualone.app.domain.member.entity.Member;
import com.rualone.app.domain.member.dao.MemberRepository;
import com.rualone.app.domain.auth.tokens.AuthTokens;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class OAuthLoginService {
    private final MemberRepository memberRepository;
    private final AuthTokensGenerator authTokensGenerator;
    private final RequestOAuthInfoService requestOAuthInfoService;

    @Transactional
    public AuthTokens login(OAuthLoginParams params) {
        OAuthInfoResponse oAuthInfoResponse = requestOAuthInfoService.request(params);

        Member member = findOrCreateMember(oAuthInfoResponse);

        AuthTokens authTokens = authTokensGenerator.generate(member.getId());
        member.updateRefreshToken(authTokens.getRefreshToken());

        return authTokens;
    }
    private Member findOrCreateMember(OAuthInfoResponse oAuthInfoResponse) {
        return memberRepository.findByEmail(oAuthInfoResponse.getEmail())
                .orElseGet(() -> newMember(oAuthInfoResponse));
    }

    private Member newMember(OAuthInfoResponse oAuthInfoResponse) {
        Member member = Member.builder()
                .email(oAuthInfoResponse.getEmail())
                .gender(oAuthInfoResponse.getGender())
                .age_range(oAuthInfoResponse.getAge_Range())
                .birthday(oAuthInfoResponse.getBirthday())
                .nickName(oAuthInfoResponse.getNickname())
                .profileImg(oAuthInfoResponse.getProfile_Image())
                .oAuthProvider(oAuthInfoResponse.getOAuthProvider())
                .build();
        return memberRepository.save(member);
    }
}

package com.rualone.app.domain.people.application;

import com.rualone.app.domain.people.api.OAuthLoginParams;
import com.rualone.app.domain.people.entity.People;
import com.rualone.app.domain.people.infoResponse.OAuthInfoResponse;
import com.rualone.app.domain.people.infoResponse.RequestOAuthInfoService;
import com.rualone.app.domain.people.dao.PeopleRepository;
import com.rualone.app.domain.people.tokens.AuthTokens;
import com.rualone.app.domain.people.tokens.AuthTokensGenerator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class OAuthLoginService {
    private final PeopleRepository memberRepository;
    private final AuthTokensGenerator authTokensGenerator;
    private final RequestOAuthInfoService requestOAuthInfoService;

    public AuthTokens login(OAuthLoginParams params) {
        OAuthInfoResponse oAuthInfoResponse = requestOAuthInfoService.request(params);
        Long memberId = findOrCreateMember(oAuthInfoResponse);
        return authTokensGenerator.generate(memberId);
    }

    private Long findOrCreateMember(OAuthInfoResponse oAuthInfoResponse) {
        return memberRepository.findByEmail(oAuthInfoResponse.getEmail())
                .map(People::getId)
                .orElseGet(() -> newMember(oAuthInfoResponse));
    }

    private Long newMember(OAuthInfoResponse oAuthInfoResponse) {
        People people = People.builder()
                .email(oAuthInfoResponse.getEmail())
                .nickname(oAuthInfoResponse.getNickname())
                .oAuthProvider(oAuthInfoResponse.getOAuthProvider())
                .build();

        return memberRepository.save(people).getId();
    }
}

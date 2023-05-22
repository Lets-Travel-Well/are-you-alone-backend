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
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class OAuthLoginService {
    private final PeopleRepository memberRepository;
    private final AuthTokensGenerator authTokensGenerator;
    private final RequestOAuthInfoService requestOAuthInfoService;

    @Transactional
    public AuthTokens login(OAuthLoginParams params) {
        OAuthInfoResponse oAuthInfoResponse = requestOAuthInfoService.request(params);

        People people = findOrCreateMember(oAuthInfoResponse);

        AuthTokens authTokens = authTokensGenerator.generate(people.getId());
        people.updateRefreshToken(authTokens.getRefreshToken());

        return authTokens;
    }
    private People findOrCreateMember(OAuthInfoResponse oAuthInfoResponse) {
        return memberRepository.findByEmail(oAuthInfoResponse.getEmail())
                .orElseGet(() -> newMember(oAuthInfoResponse));
    }

    private People newMember(OAuthInfoResponse oAuthInfoResponse) {
        People people = People.builder()
                .email(oAuthInfoResponse.getEmail())
                .nickname(oAuthInfoResponse.getNickname())
                .oAuthProvider(oAuthInfoResponse.getOAuthProvider())
                .build();
        return memberRepository.save(people);
    }
}

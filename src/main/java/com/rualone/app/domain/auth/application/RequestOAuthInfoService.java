package com.rualone.app.domain.auth.application;

import com.rualone.app.domain.auth.apiClient.OAuthApiClient;
import com.rualone.app.domain.auth.dto.infoResponse.OAuthInfoResponse;
import com.rualone.app.domain.auth.params.OAuthLoginParams;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
@Slf4j
public class RequestOAuthInfoService {
    private final Map<OAuthProvider, OAuthApiClient> clients;

    public RequestOAuthInfoService(List<OAuthApiClient> clients) {
        this.clients = clients.stream().collect(
                Collectors.collectingAndThen(
                        Collectors.toMap(OAuthApiClient::oAuthProvider, Function.identity()),
                        Collections::unmodifiableMap
                )
        );
    }

    public OAuthInfoResponse request(OAuthLoginParams params) {
        OAuthApiClient client = clients.get(params.oAuthProvider());
        log.info(client.toString());
        String accessToken = client.requestAccessToken(params);

        return client.requestOauthInfo(accessToken);
    }
}

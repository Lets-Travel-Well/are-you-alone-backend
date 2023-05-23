package com.rualone.app.domain.auth.apiClient;

import com.rualone.app.domain.auth.params.OAuthLoginParams;
import com.rualone.app.domain.auth.application.OAuthProvider;
import com.rualone.app.domain.auth.dto.infoResponse.OAuthInfoResponse;

public interface OAuthApiClient {
    OAuthProvider oAuthProvider();
    String requestAccessToken(OAuthLoginParams params);
    OAuthInfoResponse requestOauthInfo(String accessToken);
}

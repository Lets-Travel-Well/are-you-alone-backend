package com.rualone.app.domain.people.ApiClient;

import com.rualone.app.domain.people.api.OAuthLoginParams;
import com.rualone.app.domain.people.entity.OAuthProvider;
import com.rualone.app.domain.people.infoResponse.OAuthInfoResponse;

public interface OAuthApiClient {
    OAuthProvider oAuthProvider();
    String requestAccessToken(OAuthLoginParams params);
    OAuthInfoResponse requestOauthInfo(String accessToken);
}

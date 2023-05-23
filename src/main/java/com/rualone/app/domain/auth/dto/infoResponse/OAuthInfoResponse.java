package com.rualone.app.domain.auth.dto.infoResponse;

import com.rualone.app.domain.auth.application.OAuthProvider;

public interface OAuthInfoResponse {
    String getEmail();
    String getNickname();
    OAuthProvider getOAuthProvider();
}

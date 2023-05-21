package com.rualone.app.domain.people.infoResponse;

import com.rualone.app.domain.people.entity.OAuthProvider;

public interface OAuthInfoResponse {
    String getEmail();
    String getNickname();
    OAuthProvider getOAuthProvider();
}

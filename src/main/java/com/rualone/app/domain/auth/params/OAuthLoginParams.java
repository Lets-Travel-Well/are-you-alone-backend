package com.rualone.app.domain.auth.params;

import com.rualone.app.domain.auth.application.OAuthProvider;
import org.springframework.util.MultiValueMap;

//컨트롤러의 RequestBody로 사용되어 getXX라는 네이밍 X
public interface OAuthLoginParams {
    OAuthProvider oAuthProvider();
    MultiValueMap<String, String> makeBody();
}

package com.rualone.app.domain.auth.dto.infoResponse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.rualone.app.domain.auth.application.OAuthProvider;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class KakaoInfoResponse implements OAuthInfoResponse {

    @JsonProperty("kakao_account")
    private KakaoAccount kakaoAccount;

    @Getter
    @JsonIgnoreProperties(ignoreUnknown = true)
    static class KakaoAccount {
        private KakaoProfile profile;
        private String email;
        private String gender;
        private String age_range;
        private String birthday;
    }

    @Getter
    @JsonIgnoreProperties(ignoreUnknown = true)
    static class KakaoProfile {
        private String nickname;
        private String profile_image;
    }

    @Override
    public String getEmail() {
        return kakaoAccount.email;
    }
    @Override
    public String getNickname() {
        return kakaoAccount.profile.nickname;
    }

    @Override
    public String getGender() {
        return kakaoAccount.gender;
    }
    @Override

    public String getAge_Range() {
        return kakaoAccount.age_range;
    }

    @Override
    public String getBirthday() {
        return kakaoAccount.birthday;
    }

    @Override
    public String getProfile_Image(){return kakaoAccount.profile.profile_image;}
    @Override
    public OAuthProvider getOAuthProvider() {
        return OAuthProvider.KAKAO;
    }

}

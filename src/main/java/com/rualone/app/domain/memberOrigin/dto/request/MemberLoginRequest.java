package com.rualone.app.domain.memberOrigin.dto.request;

import com.rualone.app.domain.memberOrigin.entity.Member;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MemberLoginRequest {
    private String loginId;
    private String password;

    public Member ToEntity() {
        return Member.builder()
                .loginId(loginId)
                .password(password)
                .build();
    }
}

package com.rualone.app.domain.member.dto.request;

import com.rualone.app.domain.member.entity.Member;
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

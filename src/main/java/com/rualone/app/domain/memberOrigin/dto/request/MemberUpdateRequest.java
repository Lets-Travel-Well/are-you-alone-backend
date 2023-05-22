package com.rualone.app.domain.memberOrigin.dto.request;

import com.rualone.app.domain.memberOrigin.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberUpdateRequest {
    private Long id;
    private String loginId;
    private String password;
    private String hashCode;
    private String email;
    private String domain;
    public Member toEntity(){
        return Member.builder()
                .loginId(loginId)
                .password(password)
                .hashCode(hashCode)
                .email(email)
                .domain(domain)
                .build();
    }

}

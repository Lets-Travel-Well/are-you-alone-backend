package com.rualone.app.domain.memberOrigin.dto.request;

import com.rualone.app.domain.memberOrigin.entity.Member;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class MemberModifyRequest {
    private String loginId;
    private String email;
    private String domain;

    public Member toEntity(){
        return Member.builder()
                .loginId(this.loginId)
                .email(this.email)
                .domain(this.domain)
                .build();
    }
}

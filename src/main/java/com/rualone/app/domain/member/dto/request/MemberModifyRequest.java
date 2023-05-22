package com.rualone.app.domain.member.dto.request;

import com.rualone.app.domain.member.entity.Member;
import lombok.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberModifyRequest {
    private String loginId;
    private String nickName;
    private String email;


    public Member toEntity(){
        return Member.builder()
                .email(this.email)
                .nickName(this.nickName)
                .email(this.email)
                .build();
    }
}

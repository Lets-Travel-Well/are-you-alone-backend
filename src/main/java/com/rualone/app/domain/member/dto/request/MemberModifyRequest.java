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

    // TODO: 2023-05-24 : entity 비지니스 로직으로 만들기 고려해보기  
    public Member toEntity(){
        return Member.builder()
                .email(this.email)
                .nickName(this.nickName)
                .email(this.email)
                .build();
    }
}

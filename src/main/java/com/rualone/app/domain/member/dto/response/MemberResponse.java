package com.rualone.app.domain.member.dto.response;

import com.rualone.app.domain.member.entity.Member;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class MemberResponse {
    private Long id;
    private String loginId;
    private String name;
    private String email;
    private String domain;
    private Long footage;

    public  MemberResponse(Member member){
        this.id = member.getId();
        this.loginId = member.getLoginId();
        this.name = member.getName();
        this.email=member.getEmail();
        this.domain=member.getDomain();
        this.footage = member.getFootage();
    }
}

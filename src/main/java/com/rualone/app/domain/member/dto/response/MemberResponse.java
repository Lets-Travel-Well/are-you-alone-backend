package com.rualone.app.domain.member.dto.response;

import com.rualone.app.domain.member.entity.Member;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class MemberResponse {
    private Long id;
    private String nickName;
    private String email;
    private Long footage;

    public  MemberResponse(Member member){
        this.id = member.getId();
        this.nickName = member.getNickName();
        this.email=member.getEmail();
        this.footage=member.getFootage();
    }
}

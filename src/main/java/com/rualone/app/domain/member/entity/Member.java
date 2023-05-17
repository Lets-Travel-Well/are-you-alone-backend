package com.rualone.app.domain.member.entity;

import com.rualone.app.domain.member.dto.request.MemberModifyRequest;
import com.rualone.app.global.entity.BaseEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;

@Entity
@Getter
@NoArgsConstructor
@SuperBuilder
public class Member extends BaseEntity {
    private String loginId;
    private String name;
    private String password;
    private String hashCode;
    private String email;
    private String domain;
    private Long footage;

    public void modify(MemberModifyRequest memberModifyRequest){
        this.email = memberModifyRequest.getEmail();
        this.domain = memberModifyRequest.getDomain();
    }
}

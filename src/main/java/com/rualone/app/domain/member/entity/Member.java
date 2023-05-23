package com.rualone.app.domain.member.entity;

import com.rualone.app.domain.auth.application.OAuthProvider;
import com.rualone.app.domain.member.dto.request.MemberModifyRequest;
import com.rualone.app.global.entity.BaseEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
@SuperBuilder
// 회원 정보를 담을 Entity
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String email;

    private String nickName;
    private OAuthProvider oAuthProvider;
    private String refreshToken;
    private Long footage;

    @Builder
    public Member(String email, String nickName, OAuthProvider oAuthProvider) {
        this.email = email;
        this.nickName = nickName;
        this.oAuthProvider = oAuthProvider;
    }

    public void updateRefreshToken(String refreshToken){
        this.refreshToken = refreshToken;
    }

    public void modify(MemberModifyRequest memberModifyRequest){
        //getNickName으로 수정
        this.nickName = memberModifyRequest.getEmail();
    }
}

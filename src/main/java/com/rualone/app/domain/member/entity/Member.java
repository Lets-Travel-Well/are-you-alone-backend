package com.rualone.app.domain.member.entity;

import com.rualone.app.domain.auth.application.OAuthProvider;
import com.rualone.app.domain.member.dto.request.MemberModifyRequest;
import com.rualone.app.domain.member.dto.request.ProfileImgModifyRequest;
import com.rualone.app.global.entity.BaseEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
@SuperBuilder
@DynamicInsert
// 회원 정보를 담을 Entity
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String email;
    private String nickName;

    private String gender;
    private String age_range;
    private String birthday;
    private String profileImg;

    private OAuthProvider oAuthProvider;
    private String refreshToken;
    @ColumnDefault("0")
    private Long footage;

    public void updateRefreshToken(String refreshToken){
        this.refreshToken = refreshToken;
    }

    public void modify(MemberModifyRequest memberModifyRequest){
        //getNickName으로 수정
        this.nickName = memberModifyRequest.getEmail();
    }

    public void modifyProfileImg(String imgPath) {
        this.profileImg = imgPath;
    }

}

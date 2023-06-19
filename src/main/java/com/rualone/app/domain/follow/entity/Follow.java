package com.rualone.app.domain.follow.entity;

import com.rualone.app.domain.member.entity.Member;
import com.rualone.app.global.entity.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Getter
@Entity
@NoArgsConstructor
@SuperBuilder
@ToString
public class Follow extends BaseEntity {

    // 팔로우 당하는사람 from
    @ManyToOne
    @JoinColumn(name = "follower_id") // 읽기 전용으로 설정
    private Member follower;

    @ManyToOne
    @JoinColumn(name = "followee_id") // 읽기 전용으로 설정
    private Member followee;

    public Follow createFollow(Member follower, Member followee){
        return Follow.builder()
                .follower(follower)
                .followee(followee)
                .build();
    }
}

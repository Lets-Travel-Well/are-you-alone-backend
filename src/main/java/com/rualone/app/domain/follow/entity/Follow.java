package com.rualone.app.domain.follow.entity;

import com.rualone.app.global.entity.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;

@Getter
@Entity
@NoArgsConstructor
@SuperBuilder
public class Follow extends BaseEntity {
    // 팔로우 당하는사람 to
    private Long follower;
    // 팔로우 하는사람 from
    private Long followee;
}

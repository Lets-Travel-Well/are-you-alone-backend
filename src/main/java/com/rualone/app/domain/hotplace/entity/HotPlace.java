package com.rualone.app.domain.hotplace.entity;

import com.rualone.app.domain.attraction.entity.AttractionInfo;
import com.rualone.app.domain.member.entity.Member;
import com.rualone.app.global.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class HotPlace extends BaseEntity {
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    private Member member;
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "attractionInfo_content_id")
    private AttractionInfo attractionInfo;
}

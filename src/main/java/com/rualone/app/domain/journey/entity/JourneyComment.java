package com.rualone.app.domain.journey.entity;

import com.rualone.app.domain.member.entity.Member;
import com.rualone.app.global.entity.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Getter
@NoArgsConstructor
@SuperBuilder
public class JourneyComment extends BaseEntity {
    @ManyToOne()
    @JoinColumn(name = "participant_id")
    private Member participant;
    private String content;
}

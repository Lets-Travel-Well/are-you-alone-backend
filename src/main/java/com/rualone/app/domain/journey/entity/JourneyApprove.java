package com.rualone.app.domain.journey.entity;

import com.rualone.app.domain.member.entity.Member;
import com.rualone.app.global.entity.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@SuperBuilder
public class JourneyApprove extends BaseEntity {
    @ManyToOne()
    @JoinColumn(name = "participant_id")
    private Member participant;

    @Enumerated(EnumType.STRING)
    @Column
    private ParticipationStatus status;
}

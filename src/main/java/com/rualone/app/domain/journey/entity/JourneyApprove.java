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
    @ManyToOne
    @JoinColumn(name = "journey_id")
    private Journey journey;
    @Enumerated(EnumType.STRING)
    @Column
    private ParticipationStatus status;

    // 비지니스 로직
    public void changeToAgree(){
        status = ParticipationStatus.AGREE;
    }
    public void changeToDisAgree(){
        status = ParticipationStatus.DISAGREE;
    }
}

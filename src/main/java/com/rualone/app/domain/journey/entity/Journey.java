package com.rualone.app.domain.journey.entity;

import com.rualone.app.domain.member.entity.Member;
import com.rualone.app.global.entity.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor
@SuperBuilder
public class Journey extends BaseEntity {
    @ManyToOne()
    @JoinColumn(name = "leader_id")
    private Member leader;
    private String subject;
    private String content;
    private Long travelerAllCnt;
    private LocalDate deadLine;
    private LocalDate startDay;
    // true 면 끝
    private Boolean visibility;
    private Boolean complete;
    private String review;

    public void completeJourney(){
        this.complete = true;
    }
}

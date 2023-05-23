package com.rualone.app.domain.journey.entity;

import com.rualone.app.domain.attraction.entity.AttractionInfo;
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
public class JourneyPlace extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "attraction_info")
    private AttractionInfo attractionInfo;
    @ManyToOne
    @JoinColumn(name = "journey_id")
    private Journey journey;
    private String content;
    private Integer sequence;
    private String review;
}

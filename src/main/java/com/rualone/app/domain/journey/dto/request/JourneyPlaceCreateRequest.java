package com.rualone.app.domain.journey.dto.request;

import com.rualone.app.domain.attraction.entity.AttractionInfo;
import com.rualone.app.domain.journey.entity.Journey;
import com.rualone.app.domain.journey.entity.JourneyPlace;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JourneyPlaceCreateRequest {
    private int contentId;
    private String content;
    public JourneyPlace toEntity(AttractionInfo attractionInfo, Journey journey, Integer sequence){
        return JourneyPlace.builder()
                .attractionInfo(attractionInfo)
                .journey(journey)
                .content(content)
                .sequence(sequence)
                .build();
    }
}

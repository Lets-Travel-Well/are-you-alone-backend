package com.rualone.app.domain.journey.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JourneyParticipantResponse {
    private String nickName;
    private Long footage;
}

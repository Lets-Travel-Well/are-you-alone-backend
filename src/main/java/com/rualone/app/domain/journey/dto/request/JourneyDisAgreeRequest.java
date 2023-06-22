package com.rualone.app.domain.journey.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JourneyDisAgreeRequest {
    Long journeyId;
    Long memberId;
}

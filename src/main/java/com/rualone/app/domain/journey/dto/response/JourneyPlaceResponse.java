package com.rualone.app.domain.journey.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JourneyPlaceResponse {
    private String title;
    private Integer contentId;
    private String firstImage;
    private String content;
}

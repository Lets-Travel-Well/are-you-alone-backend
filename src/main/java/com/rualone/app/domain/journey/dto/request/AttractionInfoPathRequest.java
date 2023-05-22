package com.rualone.app.domain.journey.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AttractionInfoPathRequest {
    private int contentId;
    private double latitude;
    private double longitude;
}

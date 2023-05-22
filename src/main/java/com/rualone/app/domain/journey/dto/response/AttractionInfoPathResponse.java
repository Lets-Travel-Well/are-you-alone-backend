package com.rualone.app.domain.journey.dto.response;

import com.rualone.app.domain.journey.dto.request.AttractionInfoPathRequest;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AttractionInfoPathResponse {
    private int contentId;
    private double latitude;
    private double longitude;
    public AttractionInfoPathResponse(AttractionInfoPathRequest attractionInfoPathRequest){
        this.contentId = attractionInfoPathRequest.getContentId();
        this.latitude = attractionInfoPathRequest.getLatitude();
        this.longitude = attractionInfoPathRequest.getLongitude();
    }
}

package com.rualone.app.domain.attraction.dto.response;

import com.rualone.app.domain.attraction.entity.AttractionInfo;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class AttractionInfoResponse {
    private int contentId;
    private String title;
    private String addr1;
    private String tel;
    private String firstImage;
    private double latitude;
    private double longitude;

    public AttractionInfoResponse(AttractionInfo attractionInfo){
        this.contentId = attractionInfo.getContentId();
        this.title = attractionInfo.getTitle();
        this.addr1 = attractionInfo.getAddr1();
        this.tel = attractionInfo.getTel();
        this.firstImage = attractionInfo.getFirstImage();
        this.latitude = attractionInfo.getLatitude();
        this.longitude = attractionInfo.getLongitude();
    }
}

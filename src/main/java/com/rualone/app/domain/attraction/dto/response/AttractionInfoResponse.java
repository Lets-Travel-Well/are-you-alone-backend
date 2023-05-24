package com.rualone.app.domain.attraction.dto.response;

import com.rualone.app.domain.attraction.entity.AttractionInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@Data
@AllArgsConstructor
public class AttractionInfoResponse {
    private int contentId;
    private String title;
    private String addr1;
    private String tel;
    private String firstImage;
    private double latitude;
    private double longitude;

    private Long likeCnt;
    private Boolean myPlace;
    public AttractionInfoResponse(int contentId, String title, String addr1, String tel, String firstImage, double latitude, double longitude, Long likeCnt){
        this.contentId = contentId;
        this.title = title;
        this.addr1 = addr1;
        this.tel = tel;
        this.firstImage = firstImage;
        this.latitude = latitude;
        this.longitude = longitude;
        this.likeCnt = likeCnt;
        this.myPlace = false;
    }
    public void isMyHotPlace(Boolean myPlace){
        this.myPlace = myPlace;
    }
    public void setLikeCnt(Boolean zero){
        if(zero){
            likeCnt = 0L;
        }
    }
}

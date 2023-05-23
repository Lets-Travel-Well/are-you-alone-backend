package com.rualone.app.domain.hotplace.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HotPlaceResponse {
    private int contentId;
    private String title;
    private String addr1;
    private String tel;
    private String firstImage;
    private double latitude;
    private double longitude;
    private Long likeCnt;
    private Boolean myHotPlace;
    public HotPlaceResponse(int contentId, String title, String addr1, String tel, String firstImage, double latitude, double longitude, Long likeCnt){
        this.contentId = contentId;
        this.title = title;
        this.addr1 = addr1;
        this.tel = tel;
        this.firstImage = firstImage;
        this.latitude = latitude;
        this.longitude = longitude;
        this.likeCnt = likeCnt;
        this.myHotPlace = false;
    }
    public void isMyHotPlace(Boolean myHotPlace){
        System.out.println(myHotPlace);
        this.myHotPlace = myHotPlace;
    }
}

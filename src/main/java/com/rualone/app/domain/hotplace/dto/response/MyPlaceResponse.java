package com.rualone.app.domain.hotplace.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class MyPlaceResponse {
    private int contentId;
    private String title;
    private String firstImage;
    private String addr1;
    private Long likeCnt;
    public MyPlaceResponse(int contentId, String title, String firstImage, String addr1, Long likeCnt){
        this.contentId = contentId;
        this.title = title;
        this.firstImage = firstImage;
        this.addr1 = addr1;
        this.likeCnt = likeCnt;
    }
}

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
}

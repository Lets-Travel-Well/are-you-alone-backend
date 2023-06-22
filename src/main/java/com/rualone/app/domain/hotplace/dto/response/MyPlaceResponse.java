package com.rualone.app.domain.hotplace.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyPlaceResponse {
    private int contentId;
    private String title;
    private String firstImage;
}

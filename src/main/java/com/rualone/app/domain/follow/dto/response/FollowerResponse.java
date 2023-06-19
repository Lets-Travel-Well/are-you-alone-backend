package com.rualone.app.domain.follow.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Slf4j
public class FollowerResponse {
    Long followerId;
    String nickName;
//    MultipartFile imgsrc;


}

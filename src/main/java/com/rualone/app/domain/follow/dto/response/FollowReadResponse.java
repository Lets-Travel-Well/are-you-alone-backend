package com.rualone.app.domain.follow.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FollowReadResponse {
    private Long id;
    private Long follower;
    private Long followee;
}

package com.rualone.app.domain.follow.dto.request;

import com.rualone.app.domain.follow.entity.Follow;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FollowCreateRequest {
    private Long follower;
    private Long followee;

    public Follow toEntity(FollowCreateRequest followCreateRequest){
        return Follow.builder()
                .follower(follower)
                .followee(followee)
                .build();
    }
}

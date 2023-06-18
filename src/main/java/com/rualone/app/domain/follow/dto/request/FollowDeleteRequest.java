package com.rualone.app.domain.follow.dto.request;

import com.rualone.app.domain.board.entity.Post;
import com.rualone.app.domain.follow.entity.Follow;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FollowDeleteRequest {
    private Long follower;
    private Long followee;

    public Follow toEntity(FollowDeleteRequest followDeleteRequest){
        return Follow.builder()
                .follower(follower)
                .followee(followee)
                .build();
    }
}

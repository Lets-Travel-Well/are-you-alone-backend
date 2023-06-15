package com.rualone.app.domain.follow.dto.request;

import com.rualone.app.domain.board.entity.Post;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FollowCreateRequest {
    private Long follower;
    private Long followee;

}

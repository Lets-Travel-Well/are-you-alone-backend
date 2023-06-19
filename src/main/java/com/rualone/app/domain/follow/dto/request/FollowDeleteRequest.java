package com.rualone.app.domain.follow.dto.request;

import com.rualone.app.domain.board.entity.Post;
import com.rualone.app.domain.follow.entity.Follow;
import com.rualone.app.domain.member.entity.Member;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Slf4j
public class FollowDeleteRequest {
    private Long followeeId;
}

package com.rualone.app.domain.follow.dto.request;

import com.rualone.app.domain.follow.entity.Follow;
import com.rualone.app.domain.member.entity.Member;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FollowCreateRequest {
    private Long followeeId;

    /*
    1. 팔로우 할 대상의 pk
    2. 자기 자신은 아까 @~~ User user
    3. 1, 2, (PK) => memberValidator.findbyID member
    4. member를 이용해서 follow 객체를 만들고 그 객체를 db에 저장
    5. 두 객체를 이용해서 follow 객체를 찾아서
    6. follwo 삭제 하는 거
     */
}

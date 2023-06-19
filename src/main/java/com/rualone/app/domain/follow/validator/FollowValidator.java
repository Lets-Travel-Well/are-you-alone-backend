package com.rualone.app.domain.follow.validator;

import com.rualone.app.domain.follow.dao.FollowRepository;
import com.rualone.app.domain.follow.entity.Follow;
import com.rualone.app.domain.member.entity.Member;
import com.rualone.app.global.error.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

import static javax.swing.text.html.HTML.Tag.OL;

@RequiredArgsConstructor
@Slf4j
@Configuration
public class FollowValidator {
    private final FollowRepository followRepository;
    public Follow findByFollowerAndFollowee(Member follower, Member followee){
        return followRepository.findByFollowerAndFollowee(follower, followee).orElseThrow(() -> new NotFoundException(Follow.class, followee, follower));
    }
}

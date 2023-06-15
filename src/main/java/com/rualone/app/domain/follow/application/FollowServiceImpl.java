package com.rualone.app.domain.follow.application;

import com.rualone.app.domain.follow.dao.FollowRepository;
import com.rualone.app.domain.follow.dto.request.FollowDeleteRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class FollowServiceImpl implements FollowService{

    private final FollowRepository followRepository;


    @Override
    public void delete(FollowDeleteRequest followDeleteRequest) {
        followRepository.delete(followDeleteRequest);
    }

}

package com.rualone.app.domain.follow.application;

import com.rualone.app.domain.follow.dao.FollowRepository;
import com.rualone.app.domain.follow.dto.request.FollowCreateRequest;
import com.rualone.app.domain.follow.dto.request.FollowDeleteRequest;
import com.rualone.app.domain.follow.entity.Follow;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class FollowServiceImpl implements FollowService{

    private final FollowRepository followRepository;


    @Override
    public void delete(FollowDeleteRequest followDeleteRequest) {
        log.info("followServiceImpl의 delete 접속 완료");
        followRepository.delete(followDeleteRequest.toEntity(followDeleteRequest));
    }

    @Override
    public void create(FollowCreateRequest followCreateRequest) {
        log.info("followServiceImpl의 create 접속 완료");
        followRepository.save(followCreateRequest.toEntity(followCreateRequest));
    }

    @Override
    public List<Follow> read(Long followee) {
        log.info("followServiceImpl의 read접속 완료");
        log.info(String.valueOf(followee));
        List<Follow> list = followRepository.findByFollowee(followee);
        log.info("followServiceImpl의 list 사이즈 출력");
        log.info(String.valueOf(list.size()));
        return list;
    }
    /*
    1. dto => entity
    2. follow 말고 현재 로그인 사용자로 정보가져올 수 있음
     */
}

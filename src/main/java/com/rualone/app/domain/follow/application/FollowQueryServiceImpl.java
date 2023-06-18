package com.rualone.app.domain.follow.application;

import com.rualone.app.domain.follow.dao.FollowQueryRepository;
import com.rualone.app.domain.follow.entity.Follow;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class FollowQueryServiceImpl implements FollowQueryService{

    private final FollowQueryRepository followQueryRepository;
    @Override
    public List<Follow> read(Long followee) {
        log.info("followServiceImpl의 read접속 완료");
        log.info(String.valueOf(followee));
        List<Follow> list = followQueryRepository.findByFollowee(followee);
        log.info("followServiceImpl의 list 사이즈 출력");
        log.info(String.valueOf(list.size()));
        return list;
    }
}

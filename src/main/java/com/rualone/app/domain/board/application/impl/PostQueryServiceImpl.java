package com.rualone.app.domain.board.application.impl;

import com.rualone.app.domain.board.application.PostQueryService;
import com.rualone.app.domain.board.dao.PostQueryRepository;
import com.rualone.app.domain.board.dto.response.PostResponse;
import com.rualone.app.domain.board.entity.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostQueryServiceImpl implements PostQueryService {
    private final PostQueryRepository postQueryRepository;


    @Override
    public List<PostResponse> findAll() {
        return postQueryRepository.findAll();
    }
}

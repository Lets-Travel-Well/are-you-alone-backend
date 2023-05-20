package com.rualone.app.domain.board.application.impl;

import com.rualone.app.domain.board.application.PostQueryService;
import com.rualone.app.domain.board.dao.PostQueryRepository;
import com.rualone.app.domain.board.dto.response.PostDetailResponse;
import com.rualone.app.domain.board.dto.response.PostResponse;
import com.rualone.app.domain.board.entity.Post;
import com.rualone.app.domain.board.validator.PostValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PostQueryServiceImpl implements PostQueryService {
    private final PostQueryRepository postQueryRepository;
    private final PostValidator postValidator;

    @Override
    public PostDetailResponse findById(Long id) {
        postValidator.findById(id);
        return postQueryRepository.findById(id);
    }

    @Override
    public List<PostResponse> findAll() {
        return postQueryRepository.findAll();
    }
}

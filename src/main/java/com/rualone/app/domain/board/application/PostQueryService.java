package com.rualone.app.domain.board.application;

import com.rualone.app.domain.board.dto.response.PostResponse;
import com.rualone.app.domain.board.entity.Post;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public interface PostQueryService {
    List<PostResponse> findAll();
}

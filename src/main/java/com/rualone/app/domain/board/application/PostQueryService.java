package com.rualone.app.domain.board.application;

import com.rualone.app.domain.board.dto.response.PostDetailResponse;
import com.rualone.app.domain.board.dto.response.PostResponse;
import com.rualone.app.domain.board.entity.Post;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface PostQueryService {
    PostDetailResponse findById(Long id);
    List<PostResponse> findAll(Pageable pageable);
}

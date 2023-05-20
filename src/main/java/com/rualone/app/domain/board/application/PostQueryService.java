package com.rualone.app.domain.board.application;

import com.rualone.app.domain.board.dto.response.PostDetailResponse;
import com.rualone.app.domain.board.dto.response.PostResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;


public interface PostQueryService {
    PostDetailResponse findById(Long id);
    Page<PostResponse> findAll(Pageable pageable);
}

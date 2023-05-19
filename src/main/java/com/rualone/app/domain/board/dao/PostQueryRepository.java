package com.rualone.app.domain.board.dao;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.rualone.app.domain.board.dto.response.PostDetailResponse;
import com.rualone.app.domain.board.dto.response.PostResponse;
import com.rualone.app.domain.board.entity.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PostQueryRepository {
    private final JPAQueryFactory jpaQueryFactory;

    public List<PostResponse> findAll() {

        return null;
    }

    public PostDetailResponse findById(Long id) {
        return null;
    }
}

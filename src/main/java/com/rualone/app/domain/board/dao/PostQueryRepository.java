package com.rualone.app.domain.board.dao;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.rualone.app.domain.board.dto.response.PostDetailResponse;
import com.rualone.app.domain.board.dto.response.PostResponse;
import com.rualone.app.domain.board.entity.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

import static com.rualone.app.domain.board.entity.QPost.post;

@Repository
@RequiredArgsConstructor
public class PostQueryRepository {
    private final JPAQueryFactory jpaQueryFactory;

    public List<PostResponse> findAll() {
        List<Post> postResponses = jpaQueryFactory
                .select(post)
                .from(post)
                .fetch();
                List<PostResponse> list = postResponses.stream()
                .map(PostResponse::new)
                .collect(Collectors.toList());
        return list;
    }

    public PostDetailResponse findById(Long id) {
        return null;
    }
}

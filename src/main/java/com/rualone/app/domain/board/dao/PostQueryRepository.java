package com.rualone.app.domain.board.dao;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.rualone.app.domain.board.dto.response.CommentResponse;
import com.rualone.app.domain.board.dto.response.PostDetailResponse;
import com.rualone.app.domain.board.dto.response.PostResponse;
import com.rualone.app.domain.board.entity.Post;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

import static com.rualone.app.domain.board.entity.QComment.comment;
import static com.rualone.app.domain.board.entity.QPost.post;

@Repository
@RequiredArgsConstructor
@Slf4j
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
        List<CommentResponse> commentResponses = jpaQueryFactory
                .select(Projections.constructor(CommentResponse.class,
                        comment.id,
                        comment.content,
                        comment.member.name.as("authorName"),
                        comment.createDate))
                .from(comment)
                .where(comment.post.id.eq(id))
                .fetch();
        log.info(commentResponses.toString());
        PostDetailResponse postDetailResponse = jpaQueryFactory
                .select(Projections.constructor(PostDetailResponse.class,
                        post.id,
                        post.subject,
                        post.content,
                        post.hit,
                        post.member.name.as("authorName"),
                        post.createDate))
                .from(post)
                .where(post.id.eq(id))
                .fetchOne();
        postDetailResponse.setCommentList(commentResponses);
        return postDetailResponse;
    }
}

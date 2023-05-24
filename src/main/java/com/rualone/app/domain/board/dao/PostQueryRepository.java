package com.rualone.app.domain.board.dao;

import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.rualone.app.domain.board.dto.response.CommentResponse;
import com.rualone.app.domain.board.dto.response.PostDetailResponse;
import com.rualone.app.domain.board.dto.response.PostResponse;
import com.rualone.app.domain.board.entity.Post;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

import static com.querydsl.core.types.ExpressionUtils.count;
import static com.rualone.app.domain.board.entity.QComment.comment;
import static com.rualone.app.domain.board.entity.QPost.post;
import static com.rualone.app.domain.board.entity.QPostLike.postLike;

@Repository
@RequiredArgsConstructor
@Slf4j
public class PostQueryRepository {
    private final JPAQueryFactory jpaQueryFactory;

    public Page<PostResponse> findAll(Pageable pageable) {
        List<PostResponse> postResponses = jpaQueryFactory
                .select(Projections.constructor(PostResponse.class,
                        post.id,
                        post.subject,
                        post.content,
                        post.hit,
                        post.member.nickName.as("authorName"),
                        post.createDate,
                        ExpressionUtils.as(
                                JPAExpressions.select(count(postLike.id))
                                        .from(postLike)
                                        .where(postLike.post.eq(post)),
                                "like"
                        )))
                .from(post)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(postSort(pageable))
                .fetch();
        Long count = jpaQueryFactory
                .select(post.count())
                .from(post)
                .fetchOne();

        return new PageImpl<>(postResponses, pageable, count);
    }

    public PostDetailResponse findById(Long id) {
        List<CommentResponse> commentResponses = jpaQueryFactory
                .select(Projections.constructor(CommentResponse.class,
                        comment.id,
                        comment.post.id,
                        comment.content,
                        comment.member.nickName.as("authorName"),
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
                        post.member.nickName.as("authorName"),
                        ExpressionUtils.as(
                                JPAExpressions.select(count(postLike.id))
                                        .from(postLike)
                                        .where(postLike.post.eq(post)),
                                "like"
                        ),
                        post.createDate))
                .from(post)
                .where(post.id.eq(id))
                .fetchOne();
        postDetailResponse.setCommentList(commentResponses);
        return postDetailResponse;
    }
    // 전체 조회 시 정렬 기준을 정하는 메소드
    private OrderSpecifier<?> postSort(Pageable page) {
        if (!page.getSort().isEmpty()) {
            for (Sort.Order order : page.getSort()) {
                Order direction = order.getDirection().isAscending() ? Order.ASC : Order.DESC;
                switch (order.getProperty()){
                    case "id":
                        return new OrderSpecifier(direction, post.id);
                }
            }
        }
        return null;
    }
    // 좋아요 갯수를 가져오는 메소드

}
